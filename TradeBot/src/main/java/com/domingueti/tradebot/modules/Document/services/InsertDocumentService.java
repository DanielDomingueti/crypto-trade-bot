package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class InsertDocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional
	public DocumentDTO execute(DocumentInsertDTO documentInsertDTO) {
//		validator(documentInsertDTO);
		
		Document document = new Document();
		copyDtoToModel(documentInsertDTO, document);
		
		document = documentRepository.save(document);
		
		return new DocumentDTO(document);
	}

	private void copyDtoToModel(DocumentInsertDTO documentInsertDTO, Document document) {
		document.setUserId(documentInsertDTO.getUserId());
		document.setDocumentTypeId(documentInsertDTO.getDocumentTypeId());
		document.setNumber(documentInsertDTO.getNumber());
		document.setIssuingEntity(documentInsertDTO.getIssuingEntity());
		document.setIssueDate(documentInsertDTO.getIssueDate());
		document.setDueDate(documentInsertDTO.getDueDate());
		document.setLink(documentInsertDTO.getLink());
		document.setMain(documentInsertDTO.getMain());
	}
	
}
