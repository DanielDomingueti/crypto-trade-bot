package com.domingueti.tradebot.modules.TradeHistory.repositories;

import com.domingueti.tradebot.modules.TradeHistory.models.TradeHistorySm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistorySmRepository extends JpaRepository<TradeHistorySm, Long> {
}
