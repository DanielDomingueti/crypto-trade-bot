package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

import lombok.AllArgsConstructor;

@Service
public class GetInvestmentBalanceByIdService {

	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional(readOnly = true)
	public InvestmentBalanceDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
	}
	
}
