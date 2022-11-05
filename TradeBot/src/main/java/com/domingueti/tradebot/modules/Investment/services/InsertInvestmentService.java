package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class InsertInvestmentService {
	
	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertDTO dto) {
//		validator.execute(userId); check with authenticated userId;
		
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
