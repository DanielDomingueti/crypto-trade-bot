package com.domingueti.tradebot.modules.User.validators;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;

@Component
public class InsertUserValidator {

	private Map<String, String> fieldErrors;
	private Boolean validInsert;
	
	public void execute(UserInsertDTO dto) {
		
		if (dto.getPassword().length() < 8) {
			fieldErrors.put("user.password.length", "The password must have at least 8 characters.");
			validInsert = false;
		}
		
		for (DocumentInsertDTO doc : dto.getDocumentInserts()) {
			if (doc.getIssueDate().isAfter(LocalDate.now())) {
				fieldErrors.put("document.issueDate", "The document's issuing date must be before today.");
				validInsert = false;
			}
			
			if (doc.getDueDate().isBefore(LocalDate.now())) {
				fieldErrors.put("document.dueDate", "The document's due date must be after today.");
				validInsert = false;
			}
		}

		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
