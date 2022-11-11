package com.domingueti.tradebot.modules.Document.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.Document.controllers.openapi.DocumentTypeControllerOpenApi;
import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.services.types.GetDocumentTypesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/documenttypes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentTypeController implements DocumentTypeControllerOpenApi {
	
	private GetDocumentTypesService getDocumentTypesService;

	@Override
	@GetMapping("/all")
	public ResponseEntity<List<DocumentTypeDTO>> getDocumentTypes() {
		
		List<DocumentTypeDTO> documentTypes = getDocumentTypesService.execute();
		return ResponseEntity.ok().body(documentTypes);
	}
	
}
