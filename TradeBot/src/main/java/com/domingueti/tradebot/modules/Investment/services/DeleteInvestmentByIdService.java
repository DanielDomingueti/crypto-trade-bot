package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class DeleteInvestmentByIdService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		investmentRepository.deleteById(id);
	}
	
}
