package com.domingueti.tradebot.modules.CashBalance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;

public interface CashBalanceTypeRepository extends JpaRepository<CashBalanceType, Long> {

	CashBalanceType findByIdAndDeletedAtIsNull(Long id);
	
}
