package com.domingueti.tradebot.modules.CashBalance.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class GetCashBalanceTypeByIdService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional(readOnly = true)
	public CashBalanceTypeDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		CashBalanceType cashBalanceType = cashBalanceTypeRepository.findByIdAndDeletedAtIsNull(id);
		if (cashBalanceType == null) {
			return new CashBalanceTypeDTO();
		} else {
			return new CashBalanceTypeDTO(cashBalanceType);
		}
		
	}
	
}
