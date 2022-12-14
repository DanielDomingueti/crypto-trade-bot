package com.domingueti.tradebot.modules.Document.controllers;

import com.domingueti.tradebot.modules.Document.controllers.openapi.DocumentControllerOpenApi;
import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.services.GetDocumentByIdService;
import com.domingueti.tradebot.modules.Document.services.GetDocumentsByUserIdService;
import com.domingueti.tradebot.modules.Document.services.GetDocumentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentController implements DocumentControllerOpenApi {

	private GetDocumentsService getDocumentsService;
	
	private GetDocumentsByUserIdService getDocumentsByUserIdService;

	private GetDocumentByIdService getDocumentByIdService;
	
	@Override
	@GetMapping("/admin/document/all")
	public ResponseEntity<List<DocumentDTO>> getAllDocuments() {
		
		List<DocumentDTO> documents = getDocumentsService.execute();
		return ResponseEntity.ok().body(documents);
	}
	
	@Override
	@GetMapping("/document/user/{userId}")
	public ResponseEntity<List<DocumentDTO>> getDocumentsByUserId(@PathVariable Long userId) {
		
		List<DocumentDTO> documents = getDocumentsByUserIdService.execute(userId);
		return ResponseEntity.ok().body(documents);
	}
	
	@Override
	@GetMapping("/document/{id}")
	public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Long id) {
		
		DocumentDTO documentDTO = getDocumentByIdService.execute(id);
		return ResponseEntity.ok().body(documentDTO);
	}
	
}
