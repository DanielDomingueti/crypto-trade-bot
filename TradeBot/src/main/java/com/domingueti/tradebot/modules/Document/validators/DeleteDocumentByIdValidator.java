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
public class DeleteDocumentByIdValidator {
	
	private Map<String, String> fieldErrors;	
	private Boolean validDelete;
	
	@Autowired
	private UserRepository userRepository;
	
	public void execute(Document document) {
		//must not be main document of an user
		//if is not admin, must be his own document
		
		UserPrincipalDTO authUserDTO = (UserPrincipalDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User authUser = userRepository.findByIdAndDeletedAtIsNull(authUserDTO.getId());
		
		Boolean isUserDocument = false;

		for (Document userDoc : authUser.getDocuments()) {
			if (userDoc.equals(document) && userDoc.getDeletedAt() != null) {
				isUserDocument = true;
			}
		}
//		
		if (isUserDocument.equals(false) && authUser.getIsAdmin().equals(Boolean.FALSE)) {
			fieldErrors.put("document.user", "The given document is not own by the authenticated user");
			validDelete = false;
		}
		
		if (Boolean.TRUE.equals(document.getMain())) {
			fieldErrors.put("document.main", "Main document can't be deleted.");
			validDelete = false;
		}
		
		if (!validDelete) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
