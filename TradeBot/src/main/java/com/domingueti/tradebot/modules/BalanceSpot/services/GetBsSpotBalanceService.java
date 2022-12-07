package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.BsSpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.BsSpotBalanceRepository;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetBsSpotBalanceService {

    private BsSpotBalanceRepository bsSpotBalanceRepository;

    private CryptocurrencyRepository cryptocurrencyRepository;

    @Transactional(readOnly = true)
    public BsSpotBalanceDTO execute() {

        BsSpotBalanceDTO calculatedDTO = new BsSpotBalanceDTO();

        List<Long> cryptocurrencyIds = cryptocurrencyRepository.findAllByDeletedAtIsNull()
                .stream().map(crypto -> crypto.getId()).collect(Collectors.toList());

        for (Long cryptocurrencyId : cryptocurrencyIds) {
            BsSpotBalanceDTO dto = bsSpotBalanceRepository.findTop1OrderByReferenceDateDescAndCryptocurrencyId(cryptocurrencyId);

            calculatedDTO.setNetValue(calculatedDTO.getNetValue().add(dto.getNetValue()));
            calculatedDTO.setUnits(calculatedDTO.getUnits() + dto.getUnits());
            calculatedDTO.setProfit(calculatedDTO.getProfit().add(dto.getProfit()));
        }

        return calculatedDTO;
    }

}
