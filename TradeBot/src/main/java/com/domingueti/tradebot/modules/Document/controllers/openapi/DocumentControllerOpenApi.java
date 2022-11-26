package com.domingueti.tradebot.modules.Document.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;

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
	
}