package com.domingueti.tradebot.modules.AportHistory.repositories;

import com.domingueti.tradebot.modules.AportHistory.models.AportHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AportHistoryRepository extends JpaRepository<AportHistory, Long> {

}
