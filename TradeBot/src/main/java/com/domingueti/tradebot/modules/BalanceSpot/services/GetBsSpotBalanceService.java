package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.BsSpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.BsSpotBalanceRepository;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetBsSpotBalanceService {

    private BsSpotBalanceRepository bsSpotBalanceRepository;

    private CryptocurrencyRepository cryptocurrencyRepository;

    @Transactional(readOnly = true)
    public BsSpotBalanceDTO execute() {

        Double totalUnits = 0.0;
        BigDecimal totalNetValue = new BigDecimal("0.0");
        BigDecimal totalProfit = new BigDecimal("0.0");

        List<Long> cryptocurrencyIds = cryptocurrencyRepository.findAllByDeletedAtIsNull()
                .stream().map(cryptocurrency ->  cryptocurrency.getId()).collect(Collectors.toList());

        for (Long cryptocurrencyId : cryptocurrencyIds) {
            BsSpotBalance bsSpotBalance = bsSpotBalanceRepository.findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(cryptocurrencyId);
            if (bsSpotBalance != null) {
                totalUnits += bsSpotBalance.getUnits();
                totalNetValue = totalNetValue.add(bsSpotBalance.getNetValue());
                totalProfit = totalProfit.add(bsSpotBalance.getProfit());
            }
        }

        return new BsSpotBalanceDTO(totalNetValue, totalUnits, totalProfit, LocalDate.now());
    }

}
