package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.validators.InsertInvestmentBalanceValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertInvestmentBalanceService {

	private InvestmentBalanceRepository investmentBalanceRepository;
	
	private InsertInvestmentBalanceValidator validator;
	
	@Transactional
	public InvestmentBalanceDTO execute(InvestmentBalanceInsertDTO dto) {
		validator.execute(dto);

		InvestmentBalance investmentBalance = new InvestmentBalance();
		
		copyDtoToModel(dto, investmentBalance);
		investmentBalance = investmentBalanceRepository.save(investmentBalance);
		
		return new InvestmentBalanceDTO(investmentBalance);
	}

	private void copyDtoToModel(InvestmentBalanceInsertDTO dto, InvestmentBalance model) {
		model.setInvestmentId(dto.getInvestmentId());
		model.setUnits(dto.getUnits());
		model.setNetValue(dto.getNetValue());
		model.setSimulated(dto.getSimulated());
	}
	
}
