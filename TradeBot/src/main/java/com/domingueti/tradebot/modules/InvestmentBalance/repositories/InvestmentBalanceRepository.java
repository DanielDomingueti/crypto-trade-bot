package com.domingueti.tradebot.modules.InvestmentBalance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;

public interface InvestmentBalanceRepository extends JpaRepository<InvestmentBalance, Long> {

}
