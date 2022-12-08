package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.SpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.SpotBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetSpotBalanceByCryptocurrencyIdService {

    private SpotBalanceRepository spotBalanceRepository;

    @Transactional(readOnly = true)
    public SpotBalanceDTO execute(Long cryptocurrencyId) {
        SpotBalanceDTO dto = spotBalanceRepository.findTop1OrderByReferenceDateDescAndCryptocurrencyId(cryptocurrencyId);

        return dto;
    }

}
