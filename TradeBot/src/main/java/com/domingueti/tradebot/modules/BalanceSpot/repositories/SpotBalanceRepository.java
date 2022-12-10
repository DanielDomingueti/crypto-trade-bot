package com.domingueti.tradebot.modules.BalanceSpot.repositories;

import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotBalanceRepository extends JpaRepository<SpotBalance, Long> {
    SpotBalance findTop1ByInvestment_cryptocurrencyIdOrderByReferenceDateDesc(Long cryptocurrencyId);

    List<SpotBalance> findAllTop1ByInvestment_userIdOrderByReferenceDateDesc(Long userId);
}
