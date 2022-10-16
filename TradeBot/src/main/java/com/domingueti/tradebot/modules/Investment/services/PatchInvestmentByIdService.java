package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class PatchInvestmentByIdService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional
	public InvestmentDTO execute(Long id, InvestmentDTO investmentDTO) {
//		investment = validator.execute(id); insert findById inside of validator. 
		Investment investment = investmentRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(investmentDTO, investment);
		
		investment = investmentRepository.save(investment);
		
		return new InvestmentDTO(investment);
	}

	private void copyDtoToModel(InvestmentDTO investmentDTO, Investment investment) {
		investment.setUserId(investmentDTO.getUserId());
		investment.setInitialValue(investmentDTO.getInitialValue());
		investment.setUnits(investmentDTO.getUnits());
		investment.setUnitValue(investmentDTO.getUnitValue());
		investment.setSimulated(investmentDTO.getSimulated());
	}
	
}
