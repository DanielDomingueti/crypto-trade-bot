package com.domingueti.tradebot.modules.Investment.repositories;

import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalanceCashBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PivotInvestmentBalanceCashBalanceRepository extends JpaRepository<PivotInvestmentBalanceCashBalance, Long> {

}
