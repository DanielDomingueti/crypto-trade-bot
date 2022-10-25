package com.domingueti.tradebot.modules.Document.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentPatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Documents")
public interface DocumentControllerOpenApi {
	
	@ApiOperation("Fetch all documents")
	ResponseEntity<List<DocumentDTO>> getAllDocuments();

	@ApiOperation("Fetch all documents of a user")
	ResponseEntity<List<DocumentDTO>> getDocumentsByUserId(@ApiParam(value = "User ID", example = "1") Long userId);
	
	@ApiOperation("Fetch document by ID")
	ResponseEntity<DocumentDTO> getDocumentById(@ApiParam(value = "Document ID", example = "1") Long id);
	
	@ApiOperation("Insert a new document")
	ResponseEntity<DocumentDTO> insertDocument(@ApiParam(value = "JSON body for DocumentInsertDTO") DocumentInsertDTO dto);
	
	@ApiOperation("Delete a document by ID")
	ResponseEntity<Void> deleteDocumentById(@ApiParam(value = "Document ID", example = "1") Long id);
		
	@ApiOperation("Update a document by ID")
	ResponseEntity<DocumentDTO> patchDocumentById(@ApiParam(value = "Document ID", example = "1") 
		Long id, DocumentPatchDTO dto);
	
}