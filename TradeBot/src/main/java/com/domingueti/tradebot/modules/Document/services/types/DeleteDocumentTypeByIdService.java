package com.domingueti.tradebot.modules.Document.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.models.DocumentType;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class DeleteDocumentTypeByIdService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional
	public void execute(Long id) {
		
		DocumentType documentType = documentTypeRepository.findByIdAndDeletedAtIsNull(id);
		
//		validator(documentType);
		
		if (documentType == null) {
			throw new NotFoundException("Document type not found with given ID: " + id + " while deleting.");
		}
		
		documentTypeRepository.delete(documentType);
	}
}
