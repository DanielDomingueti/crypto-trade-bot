package com.domingueti.tradebot.modules.Position.repositories;

import com.domingueti.tradebot.modules.Position.models.OpenPositionSm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenPositionSmRepository extends JpaRepository<OpenPositionSm, Long> {

}
