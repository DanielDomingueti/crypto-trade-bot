package com.domingueti.tradebot.modules.Bank.repositories;

import com.domingueti.tradebot.modules.Bank.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}