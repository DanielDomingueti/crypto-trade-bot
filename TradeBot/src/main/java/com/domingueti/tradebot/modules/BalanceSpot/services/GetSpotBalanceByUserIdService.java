package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.SpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.SpotBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetSpotBalanceByUserIdService {

    private SpotBalanceRepository bsSpotBalanceRepository;

    @Transactional(readOnly = true)
    public SpotBalanceDTO execute(Long userId) {

        SpotBalanceDTO calculatedDTO = new SpotBalanceDTO();

        for (SpotBalance model : bsSpotBalanceRepository.findAllTop1OrderByReferenceDateDescAndInvestment_userId(userId)) {
            calculatedDTO.setNetValue(calculatedDTO.getNetValue().add(model.getNetValue()));
            calculatedDTO.setProfit(calculatedDTO.getProfit().add(model.getProfit()));
            calculatedDTO.setUnits(calculatedDTO.getUnits() + model.getUnits());
            calculatedDTO.setReferenceDate(model.getReferenceDate());
        }

        return calculatedDTO;
    }

}
