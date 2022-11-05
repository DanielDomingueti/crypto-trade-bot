package com.domingueti.tradebot.modules.Document.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class GetDocumentsByUserIdService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentDTO> execute(Long userId) {
//		validator.execute(userId); check with authenticated userId;
		
		List<Document> documents = documentRepository.findAllByUserIdAndDeletedAtIsNull(userId);
		
		return documents.stream().map(DocumentDTO::new).collect(Collectors.toList());
	}

}
