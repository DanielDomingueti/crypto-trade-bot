package com.domingueti.tradebot.modules.Document.services.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class GetDocumentTypesService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentTypeDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return documentTypeRepository.findAll().stream()
				.map(DocumentTypeDTO::new).toList();
	}

}
