package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class GetCashBalanceByUserIdService {

	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional(readOnly = true)
	public CashBalanceDTO execute(Long userId) {
//		validator.execute(userId); check with authenticated userId;
		
		CashBalance cashBalance = cashBalanceRepository.findByIdAndDeletedAtIsNull(userId);
		
		if (cashBalance == null) {
			throw new NotFoundException("Cash balance not found by given UserID: " + userId + " while fetching.");
		}
		
		return new CashBalanceDTO(cashBalance);
		
	}
	
}
