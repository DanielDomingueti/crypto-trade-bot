package com.domingueti.tradebot.modules.Investment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class GetInvestmentsByUserIdService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional(readOnly = true)
	public List<InvestmentDTO> execute(Long userId) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
//		return documentRepository.findAllByUserId().stream()
//				.map(DocumentDTO::new).toList();
	}
}
