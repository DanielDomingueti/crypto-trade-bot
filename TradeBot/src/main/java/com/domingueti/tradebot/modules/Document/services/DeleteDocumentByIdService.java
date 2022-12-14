package com.domingueti.tradebot.modules.Document.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.validators.DeleteDocumentByIdValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeleteDocumentByIdService {

	private DocumentRepository documentRepository;
	
	private DeleteDocumentByIdValidator validator;
	
	@Transactional
	public void execute(Long id) {
		
		Document document = documentRepository.findByIdAndDeletedAtIsNull(id);

		if (document == null) {
			throw new NotFoundException("Document not found with given ID: " + id + " while deleting.");
		}

		validator.execute(document);

		documentRepository.delete(document);
	}
}
