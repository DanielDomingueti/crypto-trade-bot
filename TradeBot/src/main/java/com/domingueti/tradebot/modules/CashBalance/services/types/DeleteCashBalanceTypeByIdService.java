package com.domingueti.tradebot.modules.CashBalance.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class DeleteCashBalanceTypeByIdService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		cashBalanceTypeRepository.deleteById(id);
	}
	
}
