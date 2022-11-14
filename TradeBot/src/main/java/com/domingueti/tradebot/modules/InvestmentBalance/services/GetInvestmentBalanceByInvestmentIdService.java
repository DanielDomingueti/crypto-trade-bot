package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.validators.GetInvestmentBalanceByInvestmentIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetInvestmentBalanceByInvestmentIdService {

	private InvestmentBalanceRepository investmentBalanceRepository;
	
	private GetInvestmentBalanceByInvestmentIdValidator validator;
	
	@Transactional(readOnly = true)
	public InvestmentBalanceDTO execute(Long investmentId) {
		validator.execute(investmentId);
		
		InvestmentBalance investmentBalance = investmentBalanceRepository.findByIdAndDeletedAtIsNull(investmentId);
		
		if (investmentBalance == null) {
			throw new NotFoundException("Investment balance not found with given InvestmentID: " + investmentId + " while fetching.");
		}
		
		return new InvestmentBalanceDTO(investmentBalance);
	}
	
}
