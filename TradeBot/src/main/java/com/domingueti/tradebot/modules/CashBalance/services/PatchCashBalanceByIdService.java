package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalancePatchDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class PatchCashBalanceByIdService {

	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional
	public CashBalanceDTO execute(Long id, CashBalancePatchDTO cashBalanceDTO) {
//		cashBalance = validator.execute(id); insert findById inside of validator. 
		CashBalance cashBalance = cashBalanceRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(cashBalanceDTO, cashBalance);
		
		cashBalance = cashBalanceRepository.save(cashBalance);
		
		return new CashBalanceDTO(cashBalance);
	}

	private void copyDtoToModel(CashBalancePatchDTO dto, CashBalance model) {
		model.setValue(dto.getValue());
	}
	
}
