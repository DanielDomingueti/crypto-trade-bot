package com.domingueti.tradebot.modules.CashBalance.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class GetCashBalanceTypeByIdService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;

	@Transactional(readOnly = true)
	public CashBalanceTypeDTO execute(Long id) {

		CashBalanceType cashBalanceType = cashBalanceTypeRepository.findByIdAndDeletedAtIsNull(id);

		if (cashBalanceType == null) {
			throw new NotFoundException("Cash balance type not found with given ID: " + id + " while fetching.");
		}

		return new CashBalanceTypeDTO(cashBalanceType);

	}

}
