package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class GetDocumentTypeByIdService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional(readOnly = true)
	public DocumentTypeDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		
		return new DocumentTypeDTO(documentTypeRepository.findByIdAndDeletedAtIsNull(id));
	}

}
