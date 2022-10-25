package com.domingueti.tradebot.modules.Investment.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetInvestmentsService {

	private InvestmentRepository investmentRepository;
	
	@Transactional(readOnly = true)
	public List<InvestmentDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return investmentRepository.findAll().stream()
				.map(InvestmentDTO::new).toList();
	}
}
