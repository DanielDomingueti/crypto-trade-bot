package com.domingueti.tradebot.modules.CashBalance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;

public interface CashBalanceRepository extends JpaRepository<CashBalance, Long> {

	CashBalance findByIdAndDeletedAtIsNull(Long id);
	
}
