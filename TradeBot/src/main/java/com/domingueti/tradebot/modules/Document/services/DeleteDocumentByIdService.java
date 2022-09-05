package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class DeleteDocumentByIdService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		documentRepository.deleteById(id);
	}
}
