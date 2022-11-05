package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class DeleteCashBalanceByIdService {

	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional
	public void execute(Long id) {
		
		CashBalance cashBalance = cashBalanceRepository.findByIdAndDeletedAtIsNull(id);
		
//		validator.execute(cashBalance);
		
		if (cashBalance == null) {
			throw new NotFoundException("Cash balance not found with given ID: " + id);
		}

		cashBalanceRepository.deleteById(id);
	
	}
	
}
