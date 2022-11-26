package com.domingueti.tradebot.modules.Document.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.validators.InsertDocumentValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertDocumentService {

	private DocumentRepository documentRepository;

	private InsertDocumentValidator validator;
	
	@Transactional
	public List<DocumentDTO> execute(List<DocumentInsertDTO> documentInserts) {
		validator.execute(documentInserts);
		
		List<Document> documents = new ArrayList<>();
		
		for (DocumentInsertDTO dto : documentInserts) {
			
			Document document = new Document();
			copyDtoToModel(dto, document);
		
			documents.add(document);
		}
		
		List<Document> savedDocuments = documentRepository.saveAll(documents);
		
		return savedDocuments.stream().map(DocumentDTO::new).collect(Collectors.toList());
	}

	private void copyDtoToModel(DocumentInsertDTO dto, Document model) {
		model.setUserId(dto.getUserId());
		model.setDocumentTypeId(dto.getDocumentTypeId());
		model.setNumber(dto.getNumber());
		model.setMain(dto.getMain());
		model.setIssuingEntity(dto.getIssuingEntity());
		model.setIssueDate(dto.getIssueDate());
		model.setDueDate(dto.getDueDate());
	}
	
}
