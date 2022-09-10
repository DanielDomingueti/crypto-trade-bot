package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.models.DocumentType;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class UpdateDocumentTypeByIdService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional
	public DocumentTypeDTO execute(Long id, DocumentTypeDTO documentTypeDTO) {
//		document = validator.execute(id); insert findById inside of validator. 
		DocumentType documentType = documentTypeRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(documentTypeDTO, documentType);
		
		documentType = documentTypeRepository.save(documentType);
		
		return new DocumentTypeDTO(documentType);
	}

	private void copyDtoToModel(DocumentTypeDTO documentTypeDTO, DocumentType documentType) {
		documentType.setId(documentTypeDTO.getId());
		documentType.setType(documentTypeDTO.getType());
		documentType.setDescription(documentTypeDTO.getDescription());		
	}
	
}
