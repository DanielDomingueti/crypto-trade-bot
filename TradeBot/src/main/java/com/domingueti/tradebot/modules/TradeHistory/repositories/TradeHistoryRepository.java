package com.domingueti.tradebot.modules.TradeHistory.repositories;

import com.domingueti.tradebot.modules.TradeHistory.models.TradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistoryRepository extends JpaRepository<TradeHistory, Long> {
}
