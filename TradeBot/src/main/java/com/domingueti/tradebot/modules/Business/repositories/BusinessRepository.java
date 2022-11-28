package com.domingueti.tradebot.modules.Business.repositories;

import com.domingueti.tradebot.modules.Business.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
