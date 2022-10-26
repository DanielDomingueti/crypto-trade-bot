package com.domingueti.tradebot.modules.CashBalance.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class GetCashBalancesService {

private CashBalanceRepository cashBalanceRepository;
	
	@Transactional(readOnly = true)
	public List<CashBalanceDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return cashBalanceRepository.findAll().stream()
				.map(CashBalanceDTO::new).toList();
	}
	
}
