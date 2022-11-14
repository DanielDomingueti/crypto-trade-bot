package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.validators.InsertInvestmentValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertInvestmentService {
	
	private InvestmentRepository investmentRepository;
	
	private InsertInvestmentValidator validator;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertDTO dto) {
		validator.execute(dto);
		
		Investment existingInvestment = investmentRepository.findByUserIdAndCryptocurrencyIdAndDeletedAtIsNull(dto.getUserId(), dto.getCryptocurrencyId());
		
		//buy new coins of existing cryptocurrency.
		if (existingInvestment != null) {
			
		}
		
		Investment investment = new Investment();
		copyDtoToModel(dto, investment);
		
		investment = investmentRepository.save(investment);
		
		return new InvestmentDTO(investment);
	}

	private void copyDtoToModel(InvestmentInsertDTO dto, Investment model) {
		model.setUserId(dto.getUserId());
		model.setCryptocurrencyId(dto.getCryptocurrencyId());
		model.setInitialValue(dto.getInitialValue());
		model.setSimulated(dto.getSimulated());
	}
	
}
