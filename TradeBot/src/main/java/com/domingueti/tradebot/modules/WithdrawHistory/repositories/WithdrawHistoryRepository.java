package com.domingueti.tradebot.modules.WithdrawHistory.repositories;

import com.domingueti.tradebot.modules.WithdrawHistory.models.WithdrawHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawHistoryRepository extends JpaRepository<WithdrawHistory, Long> {

}
