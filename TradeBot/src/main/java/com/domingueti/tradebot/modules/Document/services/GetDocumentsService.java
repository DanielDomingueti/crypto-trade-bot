package com.domingueti.tradebot.modules.Document.services;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetDocumentsService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentDTO> execute() {
		
		List<Document> documents = documentRepository.findAllByDeletedAtIsNull();
		
		return documents.stream().map(DocumentDTO::new).collect(Collectors.toList());
	}

}
