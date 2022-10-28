package com.domingueti.tradebot.modules.InvestmentBalance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Service
public class GetInvestmentBalancesService {
	
	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional(readOnly = true)
	public List<InvestmentBalanceDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return investmentBalanceRepository.findAll().stream()
				.map(InvestmentBalanceDTO::new).toList();
	}
}
