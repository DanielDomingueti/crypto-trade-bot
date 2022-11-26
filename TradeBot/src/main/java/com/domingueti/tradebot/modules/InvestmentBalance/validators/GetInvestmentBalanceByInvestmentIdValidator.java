package com.domingueti.tradebot.modules.InvestmentBalance.validators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.dtos.UserPrincipalDTO;

@Component
public class GetInvestmentBalanceByInvestmentIdValidator {
	
	private Map<String, String> fieldErrors;	
	private Boolean validInsert;

	@Autowired
	private UserRepository userRepository;
	
	public void execute(Long investmentId) {

		UserPrincipalDTO authUserDTO = (UserPrincipalDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User authUser = userRepository.findByIdAndDeletedAtIsNull(authUserDTO.getId());
		
		Boolean isUserInvestment = false;
		
		for (Investment investment : authUser.getInvestments()) {
			if (investment.getId().equals(investmentId)) {
				isUserInvestment = true;
			}
		}
		
		if (isUserInvestment.equals(false) && !authUser.getIsAdmin()) {
			fieldErrors.put("user.investmentBalance", "The user can only fetch his own investment balances.");
			validInsert = false;
		}
		
		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
}
