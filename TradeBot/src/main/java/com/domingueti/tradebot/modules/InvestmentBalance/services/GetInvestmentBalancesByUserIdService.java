package com.domingueti.tradebot.modules.InvestmentBalance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

import lombok.AllArgsConstructor;

@Service
public class GetInvestmentBalancesByUserIdService {
	
	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional(readOnly = true)
	public List<InvestmentBalanceDTO> execute(Long userId) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
//		return documentRepository.findAllByUserId().stream()
//				.map(DocumentDTO::new).toList();
	}
}
