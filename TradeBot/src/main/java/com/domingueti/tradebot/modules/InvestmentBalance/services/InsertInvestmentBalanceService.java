package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;

@Service
public class InsertInvestmentBalanceService {

	@Transactional
	public InvestmentBalanceDTO execute(InvestmentBalanceInsertDTO dto) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
	}
	
}
