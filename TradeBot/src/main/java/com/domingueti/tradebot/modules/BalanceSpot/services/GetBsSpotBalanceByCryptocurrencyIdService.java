package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.BsSpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.BsSpotBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetBsSpotBalanceByCryptocurrencyIdService {

    private BsSpotBalanceRepository bsSpotBalanceRepository;

    @Transactional(readOnly = true)
    public BsSpotBalanceDTO execute(Long cryptocurrencyId) {
        BsSpotBalance bsSpotBalance = bsSpotBalanceRepository.findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(cryptocurrencyId);

        return new BsSpotBalanceDTO(bsSpotBalance);
    }

}
