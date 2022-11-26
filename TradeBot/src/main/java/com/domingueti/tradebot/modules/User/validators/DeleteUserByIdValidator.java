package com.domingueti.tradebot.modules.User.validators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

@Component
public class DeleteUserByIdValidator {

	private Map<String, String> fieldErrors;	
	private Boolean validDelete;
	
	@Autowired
	private CashBalanceRepository cashBalanceRepository;
	
	@Autowired
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	public void execute(Long id) {

		if (cashBalanceRepository.existsByUserIdAndDeletedAtIsNull(id) || investmentBalanceRepository.existsByUserIdAndDeletedAtIsNull(id)) {
			fieldErrors.put("user.balance", "Can't delete a user with active cash or investment balance.");
			validDelete = false;
		}
		
		if (!validDelete) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
