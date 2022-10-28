package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;

@Service
public class InsertInvestmentService {
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertDTO dto) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
	}

}
