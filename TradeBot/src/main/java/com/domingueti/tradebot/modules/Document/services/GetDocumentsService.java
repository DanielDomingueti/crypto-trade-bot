package com.domingueti.tradebot.modules.Document.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetDocumentsService {

	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return documentRepository.findAll().stream()
				.map(DocumentDTO::new).toList();
//		return documentRepository.findAll().stream()
//				.map(DocumentDTO::new).toList();
	}

}
