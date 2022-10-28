package com.domingueti.tradebot.modules.CashBalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class DeleteCashBalanceByIdService {

	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		cashBalanceRepository.deleteById(id);
	}
	
}
