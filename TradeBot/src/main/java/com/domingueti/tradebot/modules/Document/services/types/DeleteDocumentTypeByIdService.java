package com.domingueti.tradebot.modules.Document.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class DeleteDocumentTypeByIdService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		documentTypeRepository.deleteById(id);
	}
}
