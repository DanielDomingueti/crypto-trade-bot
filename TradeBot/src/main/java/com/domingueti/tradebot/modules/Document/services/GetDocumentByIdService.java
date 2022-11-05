package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class GetDocumentByIdService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public DocumentDTO execute(Long id) {

		Document document = documentRepository.findByIdAndDeletedAtIsNull(id);

		if (document == null) {
			throw new NotFoundException("Document not found with given ID: " + id);
		}
		
		return new DocumentDTO(document);

	}

}
