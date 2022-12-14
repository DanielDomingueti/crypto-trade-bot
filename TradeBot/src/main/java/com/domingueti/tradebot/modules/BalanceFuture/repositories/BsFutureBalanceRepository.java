package com.domingueti.tradebot.modules.BalanceFuture.repositories;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsFutureBalanceRepository extends JpaRepository<BsFutureBalance, Long> {
    BsFutureBalance findTop1ByOrderByReferenceDateDesc();
}
