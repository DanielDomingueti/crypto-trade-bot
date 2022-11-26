package com.domingueti.tradebot.modules.Bank.repositories;

import com.domingueti.tradebot.modules.Bank.models.BankType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTypeRepository extends JpaRepository<BankType, Long> {
}