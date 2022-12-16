package com.domingueti.tradebot.modules.Document.controllers.openapi;

import com.domingueti.tradebot.modules.Document.dtos.DocumentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Documents")
public interface DocumentControllerOpenApi {
	
	@ApiOperation("Fetch all documents")
	ResponseEntity<List<DocumentDTO>> getAllDocuments(Pageable pageable);

	@ApiOperation("Fetch all documents of a user")
	ResponseEntity<List<DocumentDTO>> getDocumentsByUserId(@ApiParam(value = "User ID", example = "1") Long userId);
	
	@ApiOperation("Fetch document by ID")
	ResponseEntity<DocumentDTO> getDocumentById(@ApiParam(value = "Document ID", example = "1") Long id);
	
}