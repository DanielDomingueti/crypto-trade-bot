package com.domingueti.tradebot.modules.BalanceSpot.repositories;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.SpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotBalanceRepository extends JpaRepository<SpotBalance, Long> {
    SpotBalanceDTO findTop1OrderByReferenceDateDescAndCryptocurrencyId(Long cryptocurrencyId);

    List<SpotBalance> findAllTop1OrderByReferenceDateDescAndInvestment_userId(Long userId);
}
