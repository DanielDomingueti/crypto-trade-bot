package com.domingueti.tradebot.modules.Document.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeInsertDTO;
import com.domingueti.tradebot.modules.Document.models.DocumentType;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class InsertDocumentTypeService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional
	public DocumentTypeDTO execute(DocumentTypeInsertDTO documentTypeInsertDTO) {

		DocumentType documentType = new DocumentType();
		copyDtoToModel(documentTypeInsertDTO, documentType);
		
		documentType = documentTypeRepository.save(documentType);
		
		return new DocumentTypeDTO(documentType);
	}

	private void copyDtoToModel(DocumentTypeInsertDTO documentTypeInsertDTO, DocumentType documentType) {
		documentType.setType(documentTypeInsertDTO.getType());
		documentType.setDescription(documentTypeInsertDTO.getDescription());
	}
	
}
