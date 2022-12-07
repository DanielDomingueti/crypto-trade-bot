package com.domingueti.tradebot.modules.BalanceFuture.repositories;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.FutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.models.FutureBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutureBalanceRepository extends JpaRepository<FutureBalance, Long> {
    FutureBalanceDTO findTop1OrderByReferenceDateDescAndInvestment_userId(Long userId);
}
