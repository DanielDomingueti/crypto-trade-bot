package com.domingueti.tradebot.modules.User.validators;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeleteUserByIdValidator {

	private Map<String, String> fieldErrors;	
	private Boolean validDelete;
	
	public void execute(Long id) {

		if (!validDelete) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
