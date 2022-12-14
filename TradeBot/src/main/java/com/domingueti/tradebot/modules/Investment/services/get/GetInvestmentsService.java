package com.domingueti.tradebot.modules.Investment.services.get;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;

@Service
public class GetInvestmentsService {

	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Transactional(readOnly = true)
	public List<InvestmentDTO> execute() {
		
		List<Investment> investments = investmentRepository.findAllByDeletedAtIsNull();
		
		return investments.stream().map(InvestmentDTO::new).collect(Collectors.toList());
	}
}
