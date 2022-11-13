package com.domingueti.tradebot.modules.Document.validators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.dtos.UserPrincipalDTO;

@Component
public class GetDocumentsByUserIdValidator {

	private Map<String, String> fieldErrors;	
	private Boolean validFetch;
	
	@Autowired
	private UserRepository userRepository;
	
	public void execute(Long userId) {
		//admin can fetch any document
		//user can only fetch his own
		
		UserPrincipalDTO authUserDTO = (UserPrincipalDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User authUser = userRepository.findByIdAndDeletedAtIsNull(authUserDTO.getId());
		
		if (!authUser.getId().equals(userId) && authUser.getIsAdmin().equals(Boolean.FALSE)) {
			fieldErrors.put("document.userId", "The user can only fetch his own documents.");
			validFetch = false;
		}
		
		if (!validFetch) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
