package com.domingueti.tradebot.modules.Document.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class GetDocumentsByUserIdService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentDTO> execute(Long userId) {
//		validator.execute(userId); check with authenticated userId;
		
		return documentRepository.findAllByUserId(userId).stream()
				.map(DocumentDTO::new).toList();
//		return documentRepository.findAll().stream()
//				.map(DocumentDTO::new).toList();
	}

}
