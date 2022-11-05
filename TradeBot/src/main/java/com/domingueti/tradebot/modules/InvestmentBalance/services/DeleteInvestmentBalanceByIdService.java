package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Service
public class DeleteInvestmentBalanceByIdService {

	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional
	public void execute(Long id) {
		
		InvestmentBalance investmentBalance = investmentBalanceRepository.findByIdAndDeletedAtIsNull(id);
		
		if (investmentBalance == null) {
			throw new NotFoundException("Investment balance not found with given ID: " + id + " while deleting.");
		}
		
//		validator.execute(id); 
	
		investmentBalanceRepository.delete(investmentBalance);
	}
}
