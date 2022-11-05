package com.domingueti.tradebot.modules.CashBalance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;

public interface CashBalanceTypeRepository extends JpaRepository<CashBalanceType, Long> {

	CashBalanceType findByIdAndDeletedAtIsNull(Long id);
	
	List<CashBalanceType> findAllAndDeletedAtIsNull();
	
}
