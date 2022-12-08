package com.domingueti.tradebot.modules.BalanceFuture.repositories.simulation;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation.BsFutureBalanceSmDTO;
import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalanceSm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsFutureBalanceSmRepository extends JpaRepository<BsFutureBalanceSm, Long> {
    BsFutureBalanceSmDTO findTop1OrderByReferenceDateDesc();
}
