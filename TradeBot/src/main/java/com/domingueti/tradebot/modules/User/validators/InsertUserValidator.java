package com.domingueti.tradebot.modules.User.validators;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.models.UserType;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.modules.User.repositories.UserTypeRepository;

@Component
public class InsertUserValidator {

	private Map<String, String> fieldErrors;
	private Boolean validInsert;
	
	private static final Long NATURAL_PERSON = 1L;
	private static final Long LEGAL_PERSON = 2L;
	
	private static final Long CPF = 1L;
	private static final Long RG = 2L;
	private static final Long CNPJ = 3L;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	public void execute(UserInsertDTO dto) {
		
		int documentMainQuantity = 0;
		int cpfQuantity = 0;
		int rgQuantity = 0;
		int cnpjQuantity = 0;
		
		User user = userRepository.findByEmailAndDeletedAtIsNull(dto.getEmail());
		UserType userType = userTypeRepository.findByIdAndDeletedAtIsNull(dto.getUserTypeId());
		
		if (user != null) {
			fieldErrors.put("user.existence", "User with given email: " + dto.getEmail() + " already exists.");
			validInsert = false;
		}
		
		if (userType == null) {
			fieldErrors.put("userType.existence", "User type with ID: " + dto.getUserTypeId() + " does not exist.");
			validInsert = false;
		}
		
		if (dto.getPassword().length() < 8) {
			fieldErrors.put("user.password.length", "The password must have at least 8 characters.");
			validInsert = false;
		}
		
		for (DocumentInsertDTO doc : dto.getDocumentInserts()) {
			
			documentMainQuantity = doc.getMain() == true ? documentMainQuantity + 1 : documentMainQuantity; 
			cpfQuantity = doc.getDocumentTypeId().equals(CPF) ? cpfQuantity + 1 : cpfQuantity;
			rgQuantity = doc.getDocumentTypeId().equals(RG) ? rgQuantity + 1 : rgQuantity;
			cnpjQuantity = doc.getDocumentTypeId().equals(CNPJ) ? cnpjQuantity + 1 : cnpjQuantity;
			
			validateDocumentFields(doc, dto);

		}
		
		if (documentMainQuantity != 1) {
			fieldErrors.put("user.document.main", "One document must be the main.");
			validInsert = false;
		}

		if (dto.getUserTypeId().equals(NATURAL_PERSON) && cpfQuantity != 1) {
			fieldErrors.put("user.document.main.cpf", "At least one CPF must be inserted for natural person.");
			validInsert = false;
		}
		
		if (dto.getUserTypeId().equals(NATURAL_PERSON) && rgQuantity > 1) {
			fieldErrors.put("user.documetn.main.rg", "Max of one RG per user.");
			validInsert = false;
		}
		
		if (dto.getUserTypeId().equals(LEGAL_PERSON) && cnpjQuantity != 1) {
			fieldErrors.put("user.document.main.cnpj", "At least one CNPJ must be inserted for legal person.");
			validInsert = false;
		}
		
		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}

	private void validateDocumentFields(DocumentInsertDTO doc, UserInsertDTO dto) {
		
		if (!documentTypeRepository.existsDocumentTypeById(doc.getDocumentTypeId())) { 
			fieldErrors.put("documentType.existence", "Document type not found with given ID: " + doc.getDocumentTypeId());
			validInsert = false;
		}
		
		if (documentRepository.existsDocumentByUserId(doc.getUserId())) {
			fieldErrors.put("document.user.existence", "User with ID: " + doc.getUserId() + " owns this document.");
			validInsert = false;
		}
		
		if (doc.getIssueDate().isAfter(LocalDate.now())) {
			fieldErrors.put("document.issueDate", "The document's issuing date must be before today.");
			validInsert = false;
		}
		
		if (doc.getDueDate().isBefore(LocalDate.now())) {
			fieldErrors.put("document.dueDate", "The document's due date must be after today.");
			validInsert = false;
		}

		//Natural person can only have CPF or RG
		if (dto.getUserTypeId().equals(NATURAL_PERSON) 
				&& doc.getDocumentTypeId().equals(CNPJ)) {
			fieldErrors.put("userType.documentType", "Natural person can't have CNPJ");
			validInsert = false;
		}

		//Natural person must have CPF as main document
		if (dto.getUserTypeId().equals(NATURAL_PERSON) && doc.getMain() && !doc.getDocumentTypeId().equals(CPF)) {
			fieldErrors.put("document.main.cpf", "Natural person must have CPF as the main document.");
			validInsert = false;
		}
		
		//Legal person can only have CNPJ
		if (dto.getUserTypeId().equals(LEGAL_PERSON) 
				&& !doc.getDocumentTypeId().equals(CNPJ)) {
			fieldErrors.put("userType.documentType", "Legal person can only have CNPJ");
			validInsert = false;
		}	

		//Legal person must have CNPJ as main document
		if (dto.getUserTypeId().equals(LEGAL_PERSON) && doc.getMain() && !doc.getDocumentTypeId().equals(CNPJ)) {
			fieldErrors.put("document.main.cnpj", "Legal person must have CNPJ as the main document.");
			validInsert = false;
		}
		
		if (doc.getDocumentTypeId().equals(CNPJ) || doc.getDocumentTypeId().equals(CPF)) {
//			if (!CpfCnpjValidator.isValid(doc.getNumber())) {
//				validInsert = false;
//				fieldErrors.put("documents.number", "Número do CPF/CNPJ do cliente inválido");
//			}
		}
	}
	
}
