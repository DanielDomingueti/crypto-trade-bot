package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceInsertDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class InsertCashBalanceService {

	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional
	public CashBalanceDTO execute(CashBalanceInsertDTO cashBalanceInsertDTO) {
//		validator(cashBalanceInsertDTO);
		
		CashBalance cashBalance = new CashBalance();
		copyDtoToModel(cashBalanceInsertDTO, cashBalance);
		
		cashBalance = cashBalanceRepository.save(cashBalance);
		
		return new CashBalanceDTO(cashBalance);
	}

	private void copyDtoToModel(CashBalanceInsertDTO dto, CashBalance model) {
		model.setUserId(dto.getUserId());
		model.setCashBalanceTypeId(dto.getCashBalanceTypeId());
		model.setValue(dto.getValue());
		model.setSimulated(dto.getSimulated());
	}
	
}
