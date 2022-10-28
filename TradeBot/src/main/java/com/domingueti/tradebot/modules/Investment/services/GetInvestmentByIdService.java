package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class GetInvestmentByIdService {
	
	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional(readOnly = true)
	public InvestmentDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
	}

}
