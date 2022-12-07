package com.domingueti.tradebot.modules.Investment.repositories;

import com.domingueti.tradebot.modules.Investment.models.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

	List<Investment> findAllByDeletedAtIsNull();
	
	List<Investment> findByUserIdAndDeletedAtIsNull(Long userId);
	
	Investment findByIdAndDeletedAtIsNull(Long id);
	
	Boolean existsByIdAndDeletedAtIsNull(Long id);
	
}
