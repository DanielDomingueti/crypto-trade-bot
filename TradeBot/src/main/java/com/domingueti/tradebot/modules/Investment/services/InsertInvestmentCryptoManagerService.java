package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertExistingInvestmentCryptoService;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertNewInvestmentCryptoService;
import com.domingueti.tradebot.modules.Investment.validators.InsertInvestmentCryptoValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertInvestmentCryptoManagerService {
	
	private InvestmentRepository investmentRepository;
	private InsertExistingInvestmentCryptoService insertExistingInvestmentCryptoService;
	private InsertNewInvestmentCryptoService insertNewInvestmentCryptoService;
	private InsertInvestmentCryptoValidator validator;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertCryptoDTO dto) {
		validator.execute(dto);
		
		InvestmentDTO investmentDTO = null;
		Boolean existingInvestment = investmentRepository.existsByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getResultCryptocurrencyId(), dto.getSimulated());
		
		if (existingInvestment) {
			investmentDTO = insertExistingInvestmentCryptoService.execute(dto);
		
		} else {
			investmentDTO = insertNewInvestmentCryptoService.execute(dto);
		
		}
		
		return investmentDTO;
	}
}
