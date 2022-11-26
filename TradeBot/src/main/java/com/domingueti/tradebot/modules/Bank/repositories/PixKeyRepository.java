package com.domingueti.tradebot.modules.Bank.repositories;

import com.domingueti.tradebot.modules.Bank.models.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixKeyRepository extends JpaRepository<PixKey, Long> {
}