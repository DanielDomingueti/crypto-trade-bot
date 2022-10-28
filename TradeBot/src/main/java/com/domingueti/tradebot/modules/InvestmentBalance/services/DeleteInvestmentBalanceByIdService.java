package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Service
public class DeleteInvestmentBalanceByIdService {

	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		investmentBalanceRepository.deleteById(id);
	}
}
