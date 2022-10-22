package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeleteInvestmentBalanceByIdService {

	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		investmentBalanceRepository.deleteById(id);
	}
}
