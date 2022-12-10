package com.domingueti.tradebot.modules.BalanceFuture.services;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.BsFutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.repositories.BsFutureBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetBsFutureBalanceService {

    private BsFutureBalanceRepository bsFutureBalanceRepository;

    @Transactional(readOnly = true)
    public BsFutureBalanceDTO execute() {
        BsFutureBalanceDTO dto = new BsFutureBalanceDTO(bsFutureBalanceRepository.findTop1ByOrderByReferenceDateDesc());

        return dto;
    }

}
