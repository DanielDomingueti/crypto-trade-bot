package com.domingueti.tradebot.modules.Document.validators;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;

@Component
public class InsertDocumentValidator {
	
	private Map<String, String> fieldErrors;	
	private Boolean validInsert;
	
	private static final Integer MAIN_DOCUMENTS_BY_USER = 1;
	
	public void execute(List<DocumentInsertDTO> dtos) {

		int counter = 0;
		
		for (DocumentInsertDTO dto : dtos) {
			if (Boolean.TRUE.equals(dto.getMain())) {
				counter++;
			}
		}

		if (counter != MAIN_DOCUMENTS_BY_USER) {
			fieldErrors.put("documents.isMain.over", "Only one main document is permitted by user");
			validInsert = false;
		}
		
		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}

}
