package com.domingueti.tradebot.modules.Investment.repositories;

import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PivotInvestmentBalancesRepository extends JpaRepository<PivotInvestmentBalances, Long> {

}
