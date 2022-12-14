package com.domingueti.tradebot.modules.BalanceSpot.repositories;

import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsSpotBalanceRepository extends JpaRepository<BsSpotBalance, Long> {
    BsSpotBalance findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(Long cryptocurrencyId);
}
