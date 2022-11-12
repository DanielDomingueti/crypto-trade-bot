package com.domingueti.tradebot.modules.InvestmentBalance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;

public interface InvestmentBalanceRepository extends JpaRepository<InvestmentBalance, Long> {

	@Query(value = ""
			+ "SELECT bal.* FROM tb_investment_balance bal"
			+ "WHERE inv.user_id = :userId "
			+ "AND bal.deleted_at IS NULL "
			+ "INNER JOIN tb_investment inv ON bal.investment_id = inv.id",
			nativeQuery = true)
	List<InvestmentBalance> findByUserIdAndDeletedAtIsNull(Long userId);
	
	List<InvestmentBalance> findAllByDeletedAtIsNull();
	
	InvestmentBalance findByIdAndDeletedAtIsNull(Long id);
	
}
