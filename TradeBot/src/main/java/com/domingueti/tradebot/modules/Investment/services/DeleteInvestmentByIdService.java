package com.domingueti.tradebot.modules.Investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class DeleteInvestmentByIdService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional
	public void execute(Long id) {
		
		Investment investment = investmentRepository.findByIdAndDeletedAtIsNull(id);
		
//		validator.execute(investment);
		
		if (investment == null) {
			throw new NotFoundException("Investment not found with given ID: " + id);
		}
		
		investmentRepository.delete(investment);
	}
	
}
