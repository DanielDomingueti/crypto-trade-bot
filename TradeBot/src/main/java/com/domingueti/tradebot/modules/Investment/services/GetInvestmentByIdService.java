package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetInvestmentByIdService {
	
	private InvestmentRepository investmentRepository;
	
	@Transactional(readOnly = true)
	public InvestmentDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
	}

}
