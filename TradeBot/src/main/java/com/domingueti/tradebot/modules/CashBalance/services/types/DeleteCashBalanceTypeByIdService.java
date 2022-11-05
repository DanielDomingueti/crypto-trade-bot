package com.domingueti.tradebot.modules.CashBalance.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class DeleteCashBalanceTypeByIdService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional
	public void execute(Long id) {

		CashBalanceType cashBalanceType = cashBalanceTypeRepository.findByIdAndDeletedAtIsNull(id);
		
//		validator.execute(cashBalanceType);
		
		if (cashBalanceType == null) {
			throw new NotFoundException("Cash balance type not found with given ID: " + id + " while deleting.");
		}
		
		cashBalanceTypeRepository.delete(cashBalanceType);
	
	}
	
}
