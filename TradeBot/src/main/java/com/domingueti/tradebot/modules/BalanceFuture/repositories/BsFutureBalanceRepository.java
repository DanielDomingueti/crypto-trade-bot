package com.domingueti.tradebot.modules.BalanceFuture.repositories;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.BsFutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsFutureBalanceRepository extends JpaRepository<BsFutureBalance, Long> {
    BsFutureBalanceDTO findTop1OrderByReferenceDateDesc();
}
