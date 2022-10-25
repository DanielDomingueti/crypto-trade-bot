package com.domingueti.tradebot.modules.Document.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentTypePatchDTO;
import com.domingueti.tradebot.modules.Document.models.DocumentType;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;

@Service
public class PatchDocumentTypeByIdService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Transactional
	public DocumentTypeDTO execute(Long id, DocumentTypePatchDTO documentTypeDTO) {
//		document = validator.execute(id); insert findById inside of validator. 
		DocumentType documentType = documentTypeRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(documentTypeDTO, documentType);
		
		documentType = documentTypeRepository.save(documentType);
		
		return new DocumentTypeDTO(documentType);
	}

	private void copyDtoToModel(DocumentTypePatchDTO documentTypeDTO, DocumentType documentType) {
		documentType.setType(documentTypeDTO.getType());
		documentType.setDescription(documentTypeDTO.getDescription());		
	}
	
}
