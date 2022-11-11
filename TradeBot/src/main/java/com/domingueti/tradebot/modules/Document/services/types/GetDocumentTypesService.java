package com.domingueti.tradebot.modules.Document.services.types;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.models.DocumentType;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class GetDocumentTypesService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional(readOnly = true)
	public List<DocumentTypeDTO> execute() {
		
		List<DocumentType> documentTypes = documentTypeRepository.findAllByDeletedAtIsNull();
		
		return documentTypes.stream().map(DocumentTypeDTO::new).collect(Collectors.toList());
	}

}
