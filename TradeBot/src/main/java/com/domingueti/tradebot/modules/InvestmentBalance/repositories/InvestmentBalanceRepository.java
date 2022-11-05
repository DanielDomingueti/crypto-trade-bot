package com.domingueti.tradebot.modules.InvestmentBalance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;

public interface InvestmentBalanceRepository extends JpaRepository<InvestmentBalance, Long> {

	List<InvestmentBalance> findByUserIdAndDeletedAtIsNull(Long userId);
	
	List<InvestmentBalance> findAllByDeletedAtIsNull();
	
	InvestmentBalance findByIdAndDeletedAtIsNull(Long id);
	
}
