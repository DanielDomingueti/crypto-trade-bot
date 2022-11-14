package com.domingueti.tradebot.modules.User.validators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Component
public class PatchUserByIdValidator {

	private Map<String, String> fieldErrors;
	private Boolean validPatch;
	
	@Autowired
	private UserRepository userRepository;
	
	public void execute(Long id, UserPatchDTO userDTO) {
		
		User userById = userRepository.findByIdAndDeletedAtIsNull(id);
		
		if (userById == null) {
			fieldErrors.put("user.existence", "User not found with given ID: " + id + " while fetching.");
			validPatch = false;
		}
		
		User userByEmail = userRepository.findByEmailAndDeletedAtIsNull(userDTO.getEmail());
		
		if (userByEmail != null) {
			fieldErrors.put("user.email", "Email used for patching is already in use: " + userDTO.getEmail());
			validPatch = false;
		}
		
		if (!validPatch) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
