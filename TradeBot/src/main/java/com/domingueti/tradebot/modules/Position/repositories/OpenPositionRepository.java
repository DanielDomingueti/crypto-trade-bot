package com.domingueti.tradebot.modules.Position.repositories;

import com.domingueti.tradebot.modules.Position.models.OpenPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenPositionRepository extends JpaRepository<OpenPosition, Long> {

}
