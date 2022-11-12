package com.domingueti.tradebot.modules.InvestmentBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Service
public class InsertInvestmentBalanceService {

	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional
	public InvestmentBalanceDTO execute(InvestmentBalanceInsertDTO dto) {
//		validator.execute(userId); check with authenticated userId;

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
