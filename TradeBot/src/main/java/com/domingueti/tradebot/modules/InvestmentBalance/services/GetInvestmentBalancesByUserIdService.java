package com.domingueti.tradebot.modules.InvestmentBalance.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Service
public class GetInvestmentBalancesByUserIdService {
	
	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional(readOnly = true)
	public List<InvestmentBalanceDTO> execute(Long userId) {
//		validator.execute(userId); check with authenticated userId;

		List<InvestmentBalance> investmentBalances = investmentBalanceRepository.findByUserIdAndDeletedAtIsNull(userId);
		
		return investmentBalances.stream().map(InvestmentBalanceDTO::new).collect(Collectors.toList());
	}
}
