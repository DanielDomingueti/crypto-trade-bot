package com.domingueti.tradebot.modules.Investment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Investment.models.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

	List<Investment> findAllByDeletedAtIsNull();
	
	List<Investment> findByUserIdAndDeletedAtIsNull(Long userId);
	
	Investment findByIdAndDeletedAtIsNull(Long id);
	
	Investment findByUserIdAndCryptocurrencyIdAndDeletedAtIsNull(Long userId, Long cryptocurrencyId);

	Boolean existsByIdAndDeletedAtIsNull(Long id);
	
}
