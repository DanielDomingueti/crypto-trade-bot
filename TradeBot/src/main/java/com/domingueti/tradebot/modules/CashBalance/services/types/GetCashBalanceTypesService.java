package com.domingueti.tradebot.modules.CashBalance.services.types;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class GetCashBalanceTypesService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional(readOnly = true)
	public List<CashBalanceTypeDTO> execute() {
		
		List<CashBalanceType> cashBalanceTypes = cashBalanceTypeRepository.findAllByDeletedAtIsNull();
		
		return cashBalanceTypes.stream().map(CashBalanceTypeDTO::new).collect(Collectors.toList());
	}
	
}
