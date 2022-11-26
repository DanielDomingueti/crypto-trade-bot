package com.domingueti.tradebot.modules.Document.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.validators.DeleteDocumentByIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeleteDocumentByIdService {

	private DocumentRepository documentRepository;
	
	private DeleteDocumentByIdValidator validator;
	
	@Transactional
	public void execute(Long id) {
		
		Document document = documentRepository.findByIdAndDeletedAtIsNull(id);

		validator.execute(document);
		
		if (document == null) {
			throw new NotFoundException("Document not found with given ID: " + id + " while deleting.");
		}
		
		documentRepository.delete(document);
	}
}
