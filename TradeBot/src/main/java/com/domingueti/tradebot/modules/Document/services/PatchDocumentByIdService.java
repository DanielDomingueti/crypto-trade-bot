package com.domingueti.tradebot.modules.Document.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentPatchDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;

@Service
public class PatchDocumentByIdService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional
	public DocumentDTO execute(Long id, DocumentPatchDTO documentDTO) {
//		document = validator.execute(id); insert findById inside of validator. 
		Document document = documentRepository.findByIdAndDeletedAtIsNull(id);

		if (document == null) {
			throw new NotFoundException("Document not found with given ID: " + id + " while patching.");
		}
		
		copyDtoToModel(documentDTO, document);
		document = documentRepository.save(document);
		
		return new DocumentDTO(document);
	}

	private void copyDtoToModel(DocumentPatchDTO dto, Document model) {
		model.setLink(dto.getLink() != null ? dto.getLink() : model.getLink());
		model.setMain(dto.getMain() != null ? dto.getMain() : model.getMain());
	}
	
}
