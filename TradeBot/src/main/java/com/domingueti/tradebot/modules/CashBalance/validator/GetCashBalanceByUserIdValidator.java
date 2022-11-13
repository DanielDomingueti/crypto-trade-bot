package com.domingueti.tradebot.modules.CashBalance.validator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.dtos.UserPrincipalDTO;

@Component
public class GetCashBalanceByUserIdValidator {
	
	private Map<String, String> fieldErrors;	
	private Boolean validInsert;
	
	@Autowired
	private UserRepository userRepository;
	
	public void execute(Long userId) {
		User user = userRepository.findByIdAndDeletedAtIsNull(userId);
		
		UserPrincipalDTO authPrincipalDTO = (UserPrincipalDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		User authUser = new User();
		copyPrincipalToUser(authPrincipalDTO, authUser);
		
		if (!user.equals(authUser)) {
			fieldErrors.put("user.id", "The authenticated user does not have access to other user's cash balance");
			validInsert = false;
		}
		
		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
		
	}

	private void copyPrincipalToUser(UserPrincipalDTO dto, User authUser) {
		authUser.setId(dto.getId());
		authUser.setName(dto.getName());
		authUser.setEmail(dto.getCredential());
	}

}
