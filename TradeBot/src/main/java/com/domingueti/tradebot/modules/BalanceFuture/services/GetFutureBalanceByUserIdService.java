package com.domingueti.tradebot.modules.BalanceFuture.services;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.FutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.models.FutureBalance;
import com.domingueti.tradebot.modules.BalanceFuture.repositories.FutureBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetFutureBalanceByUserIdService {

    private FutureBalanceRepository futureBalanceRepository;

    @Transactional(readOnly = true)
    public FutureBalanceDTO execute(Long userId) {
        FutureBalance futureBalance = futureBalanceRepository.findTop1ByInvestment_userIdOrderByReferenceDateDesc(userId);

        return new FutureBalanceDTO(futureBalance);
    }

}
