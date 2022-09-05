package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class PatchDocumentByIdService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional
	public DocumentDTO execute(Long id, DocumentDTO documentDTO) {
//		document = validator.execute(id); insert findById inside of validator. 
		Document document = documentRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(documentDTO, document);
		
		document = documentRepository.save(document);
		
		return new DocumentDTO(document);
	}

	private void copyDtoToModel(DocumentDTO documentDTO, Document document) {
		document.setUserId(documentDTO.getUserId());
		document.setNumber(documentDTO.getNumber());
		document.setMain(documentDTO.getMain());
		document.setDocumentTypeId(documentDTO.getDocumentTypeDTO().getId());
		
	}
	
}
