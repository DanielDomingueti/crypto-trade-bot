package com.domingueti.tradebot.modules.Position.repositories;

import com.domingueti.tradebot.modules.Position.models.OpenPositionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenPositionTypeRepository extends JpaRepository<OpenPositionType, Long> {

}
