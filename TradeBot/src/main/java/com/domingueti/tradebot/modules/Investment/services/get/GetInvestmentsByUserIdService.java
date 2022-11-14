package com.domingueti.tradebot.modules.Investment.services.get;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.validators.GetInvestmentsByUserIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetInvestmentsByUserIdService {

	private InvestmentRepository investmentRepository;
	
	private GetInvestmentsByUserIdValidator validator;
	
	@Transactional(readOnly = true)
	public List<InvestmentDTO> execute(Long userId) {
		validator.execute(userId);
		
		List<Investment> investments = investmentRepository.findByUserIdAndDeletedAtIsNull(userId);
		
		return investments.stream().map(InvestmentDTO::new).collect(Collectors.toList());
	}
}
