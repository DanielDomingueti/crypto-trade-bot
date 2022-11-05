package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentPatchDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class PatchInvestmentByIdService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional
	public InvestmentDTO execute(Long id, InvestmentPatchDTO investmentDTO) {
//		investment = validator.execute(id); insert findById inside of validator. 
		Investment investment = investmentRepository.findByIdAndDeletedAtIsNull(id);
		
		if (investment == null) {
			throw new NotFoundException("Investment not found with given ID: " + id + " while patching.");
		}
		
		copyDtoToModel(investmentDTO, investment);
		investment = investmentRepository.save(investment);
		
		return new InvestmentDTO(investment);
	}

	private void copyDtoToModel(InvestmentPatchDTO dto, Investment model) {
		model.setInitialValue(dto.getInitialValue() != null ? dto.getInitialValue() : model.getInitialValue());
		model.setUnitValue(dto.getUnitValue() != null ? dto.getUnitValue() : model.getUnitValue());
		model.setActive(dto.getActive() != null ? dto.getActive() : model.getActive());
	}
	
}
