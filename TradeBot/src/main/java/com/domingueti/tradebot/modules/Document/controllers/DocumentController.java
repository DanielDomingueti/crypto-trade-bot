package com.domingueti.tradebot.modules.Document.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentPatchDTO;
import com.domingueti.tradebot.modules.Document.services.DeleteDocumentByIdService;
import com.domingueti.tradebot.modules.Document.services.GetDocumentByIdService;
import com.domingueti.tradebot.modules.Document.services.GetDocumentsByUserIdService;
import com.domingueti.tradebot.modules.Document.services.InsertDocumentService;
import com.domingueti.tradebot.modules.Document.services.PatchDocumentByIdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags = "Documents")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

	private GetDocumentsByUserIdService getDocumentsByUserIdService;

	private GetDocumentByIdService getDocumentByIdService;
	
	private InsertDocumentService insertDocumentService;
	
	private DeleteDocumentByIdService deleteDocumentByIdService;
	
	private PatchDocumentByIdService patchDocumentByIdService;
	
	@ApiOperation("Fetch all documents of a user")
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<DocumentDTO>> getDocumentsByUserId(@PathVariable Long userId) {
		List<DocumentDTO> documents = getDocumentsByUserIdService.execute(userId);
		return ResponseEntity.ok().body(documents);
	}
	
	@ApiOperation("Fetch document by ID")
	@GetMapping("/{id}")
	public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Long id) {
		DocumentDTO documentDTO = getDocumentByIdService.execute(id);
		return ResponseEntity.ok().body(documentDTO);
	}
	
	@ApiOperation("Insert a new document")
	@PostMapping
	public ResponseEntity<DocumentDTO> insertDocument(@RequestBody DocumentInsertDTO dto) {
		DocumentDTO documentDTO = insertDocumentService.execute(dto);
		return ResponseEntity.ok().body(documentDTO);
	}
	
	@ApiOperation("Delete a document by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDocumentById(@PathVariable Long id) {
		deleteDocumentByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Update a document by ID")
	@PatchMapping("/{id}")
	public ResponseEntity<DocumentDTO> patchDocumentById(@PathVariable Long id, @RequestBody DocumentPatchDTO dto) {
		DocumentDTO documentDTO = patchDocumentByIdService.execute(id, dto);
		return ResponseEntity.ok().body(documentDTO);
	}
	
}
