package com.domingueti.tradebot.modules.CashBalance.services.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class GetCashBalanceTypesService {

@Autowired
private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional(readOnly = true)
	public List<CashBalanceTypeDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return cashBalanceTypeRepository.findAll().stream()
				.map(CashBalanceTypeDTO::new).toList();
	}
	
}
