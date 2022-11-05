package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
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
		
		CashBalance cashBalance = cashBalanceRepository.findByIdAndDeletedAtIsNull(id);
		
		if (cashBalance == null) {
			throw new NotFoundException("Cash balance not found with given ID: " + id + " while fetching.");
		}
		
		return new CashBalanceDTO(cashBalance);
		
	}
	
}
