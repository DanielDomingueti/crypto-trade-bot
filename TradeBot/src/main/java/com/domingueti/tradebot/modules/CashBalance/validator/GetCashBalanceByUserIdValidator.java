package com.domingueti.tradebot.modules.CashBalance.validator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Component
public class GetCashBalanceByUserIdValidator {
	
	private Map<String, String> fieldErrors;	
	private Boolean validInsert;
	
	@Autowired
	private UserRepository userRepository;
	
	public void execute(Long userId, HttpServletRequest request) {
		User user = userRepository.findByIdAndDeletedAtIsNull(userId);
		
		if (!user.equals((User) request.getUserPrincipal())) {
			fieldErrors.put("user.id", "The authenticated user does not have access to other user's cash balance");
			validInsert = false;
		}
		
		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Erro ao validar os dados inseridos");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
		
	}

}
