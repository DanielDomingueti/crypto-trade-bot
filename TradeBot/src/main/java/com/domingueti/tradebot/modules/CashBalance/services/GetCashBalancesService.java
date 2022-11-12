package com.domingueti.tradebot.modules.CashBalance.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;

@Service
public class GetCashBalancesService {

@Autowired
private CashBalanceRepository cashBalanceRepository;
	
	@Transactional(readOnly = true)
	public List<CashBalanceDTO> execute() {
		
		List<CashBalance> cashBalances = cashBalanceRepository.findAllByDeletedAtIsNull();
		
		return cashBalances.stream().map(CashBalanceDTO::new).collect(Collectors.toList());
	}
	
}
