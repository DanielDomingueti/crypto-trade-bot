package com.domingueti.tradebot.modules.Document.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class GetDocumentsService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentDTO> execute() {
		
		List<Document> documents = documentRepository.findAllByDeletedAtIsNull();
		
		return documents.stream().map(DocumentDTO::new).toList();
	}

}
