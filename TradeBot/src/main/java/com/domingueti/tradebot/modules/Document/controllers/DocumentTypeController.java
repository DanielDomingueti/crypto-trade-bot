package com.domingueti.tradebot.modules.DocumentType.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeInsertDTO;
import com.domingueti.tradebot.modules.Document.services.DeleteDocumentTypeByIdService;
import com.domingueti.tradebot.modules.Document.services.GetDocumentTypeByIdService;
import com.domingueti.tradebot.modules.Document.services.GetDocumentTypesService;
import com.domingueti.tradebot.modules.Document.services.InsertDocumentTypeService;
import com.domingueti.tradebot.modules.DocumentType.controllers.openapi.DocumentTypeControllerOpenApi;
import com.domingueti.tradebot.modules.DocumentType.dtos.DocumentTypePatchDTO;
import com.domingueti.tradebot.modules.DocumentType.services.PatchDocumentTypeByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/documents", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentTypeController implements DocumentTypeControllerOpenApi {
	
	private GetDocumentTypesService getDocumentTypesService;

	private GetDocumentTypeByIdService getDocumentTypeByIdService;
	
	private InsertDocumentTypeService insertDocumentTypeService;
	
	private DeleteDocumentTypeByIdService deleteDocumentTypeByIdService;
	
	private PatchDocumentTypeByIdService patchDocumentTypeByIdService;
	
	@GetMapping("/{id}")
	public ResponseEntity<DocumentTypeDTO> getDocumentTypeById(@PathVariable Long id) {
		
		DocumentTypeDTO documentTypeDTO = getDocumentTypeByIdService.execute(id);
		return ResponseEntity.ok().body(documentTypeDTO);
	}
	
	@PostMapping
	public ResponseEntity<DocumentTypeDTO> insertDocumentType(@RequestBody DocumentTypeInsertDTO dto) {
		
		DocumentTypeDTO documentTypeDTO = insertDocumentTypeService.execute(dto);
		return ResponseEntity.ok().body(documentTypeDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDocumentTypeById(@PathVariable Long id) {
		
		deleteDocumentTypeByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<DocumentTypeDTO> patchDocumentTypeById(@PathVariable Long id, @RequestBody DocumentTypePatchDTO dto) {
		
		DocumentTypeDTO documentTypeDTO = patchDocumentTypeByIdService.execute(id, dto);
		return ResponseEntity.ok().body(documentTypeDTO);
	}
	
}
