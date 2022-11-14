package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertExistingInvestmentCryptoService;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertExistingInvestmentFiatService;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertNewInvestmentCryptoService;
import com.domingueti.tradebot.modules.Investment.services.insert.InsertNewInvestmentFiatService;
import com.domingueti.tradebot.modules.Investment.validators.InsertInvestmentValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertInvestmentManagerService {
	
	private InvestmentRepository investmentRepository;
	private InsertExistingInvestmentFiatService insertExistingInvestmentFiatService;
	private InsertExistingInvestmentCryptoService insertExistingInvestmentCryptoService;
	private InsertNewInvestmentFiatService insertNewInvestmentFiatService;
	private InsertNewInvestmentCryptoService insertNewInvestmentCryptoService;
	private InsertInvestmentValidator validator;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertDTO dto) {
		validator.execute(dto);
		
		InvestmentDTO investmentDTO = null;
		Boolean existingInvestment = investmentRepository.existsByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getCryptocurrencyId(), dto.getSimulated());
		Boolean isFiat = dto.getIsFiat();
		
		if (existingInvestment) {
			if (isFiat) {
				//Insert existing investment with FIAT
				investmentDTO = insertExistingInvestmentFiatService.execute(dto);
			} else {
				//Insert existing investment with CRYPTO
				investmentDTO = insertExistingInvestmentCryptoService.execute(dto);
			}
		} else {
			if (isFiat) {
				//Insert brand new investment with FIAT
				investmentDTO = insertNewInvestmentFiatService.execute(dto);
			} else {
				//Insert brand new investment with CRYPTO
				investmentDTO = insertNewInvestmentCryptoService.execute(dto);
			}
		}
		
		return investmentDTO;
	}

}
