package com.domingueti.tradebot.modules.User.validators;

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
public class GetUserByIdValidator {

	private Map<String, String> fieldErrors;	
	private Boolean validFetch;
	
	@Autowired
	private UserRepository userRepository;
	
	public void execute(Long id) {

		UserPrincipalDTO authUserDTO = (UserPrincipalDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User authUser = userRepository.findByIdAndDeletedAtIsNull(authUserDTO.getId());
		
		if (authUser == null) {
			fieldErrors.put("user.existence", "User not found with given ID: " + id + " while fetching.");
			validFetch = false;
		}
		
		if (!authUser.getId().equals(id) && authUser.getIsAdmin().equals(Boolean.FALSE)) {
			fieldErrors.put("user.id", "The user can only fetch his own data.");
			validFetch = false;
		}
		
		if (!validFetch) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
		
	}
	
}
