package com.domingueti.tradebot.modules.InvestmentBalance.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.validators.GetInvestmentBalancesByUserIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetInvestmentBalancesByUserIdService {
	
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	private GetInvestmentBalancesByUserIdValidator validator;
	
	@Transactional(readOnly = true)
	public List<InvestmentBalanceDTO> execute(Long userId) {
		validator.execute(userId);

		List<InvestmentBalance> investmentBalances = investmentBalanceRepository.findByUserIdAndDeletedAtIsNull(userId);
		
		return investmentBalances.stream().map(InvestmentBalanceDTO::new).collect(Collectors.toList());
	}
}
