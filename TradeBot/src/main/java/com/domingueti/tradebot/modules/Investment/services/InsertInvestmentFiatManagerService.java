package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertFiatDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertExistingInvestmentFiatService;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertNewInvestmentFiatService;
import com.domingueti.tradebot.modules.Investment.validators.InsertInvestmentFiatValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertInvestmentFiatManagerService {
	
	private InvestmentRepository investmentRepository;
	private InsertExistingInvestmentFiatService insertExistingInvestmentFiatService;
	private InsertNewInvestmentFiatService insertNewInvestmentFiatService;
	private InsertInvestmentFiatValidator validator;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertFiatDTO dto) {
		validator.execute(dto);
		
		InvestmentDTO investmentDTO = null;
		Boolean existingInvestment = investmentRepository.existsByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getCryptocurrencyId(), dto.getSimulated());
		
		if (existingInvestment) {
			investmentDTO = insertExistingInvestmentFiatService.execute(dto);
		
		} else {
			investmentDTO = insertNewInvestmentFiatService.execute(dto);
		
		}
		
		return investmentDTO;
	}
}
