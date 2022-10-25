package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalancePatchDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Service
public class PatchInvestmentBalanceByIdService {

	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional
	public InvestmentBalanceDTO execute(Long id, InvestmentBalancePatchDTO investmentBalanceDTO) {
//		investment = validator.execute(id); insert findById inside of validator. 
		InvestmentBalance investmentBalance = investmentBalanceRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(investmentBalanceDTO, investmentBalance);
		
		investmentBalance = investmentBalanceRepository.save(investmentBalance);
		
		return new InvestmentBalanceDTO(investmentBalance);
	}

	private void copyDtoToModel(InvestmentBalancePatchDTO dto, InvestmentBalance model) {
		model.setUnits(dto.getUnits() != null ? dto.getUnits() : model.getUnits());
		model.setNetValue(dto.getNetValue() != null ? dto.getNetValue() : model.getNetValue());
	}
	
}
