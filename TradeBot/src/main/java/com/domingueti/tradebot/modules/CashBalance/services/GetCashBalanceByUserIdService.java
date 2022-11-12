package com.domingueti.tradebot.modules.CashBalance.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;
import com.domingueti.tradebot.modules.CashBalance.validator.GetCashBalanceByUserIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetCashBalanceByUserIdService {

	private CashBalanceRepository cashBalanceRepository;
	
	private GetCashBalanceByUserIdValidator validator;
	
	@Transactional(readOnly = true)
	public CashBalanceDTO execute(Long userId, HttpServletRequest request) {
		validator.execute(userId, request);
		
		CashBalance cashBalance = cashBalanceRepository.findByIdAndDeletedAtIsNull(userId);
		
		if (cashBalance == null) {
			throw new NotFoundException("Cash balance not found by given UserID: " + userId + " while fetching.");
		}
		
		return new CashBalanceDTO(cashBalance);
		
	}
	
}
