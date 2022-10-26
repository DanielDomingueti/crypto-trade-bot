package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class GetCashBalanceByIdService {

	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional(readOnly = true)
	public CashBalanceDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		CashBalance doc = cashBalanceRepository.findByIdAndDeletedAtIsNull(id);
		if (doc == null) {
			return new CashBalanceDTO();
		} else {
			return new CashBalanceDTO(doc);
		}
		
	}
	
}
