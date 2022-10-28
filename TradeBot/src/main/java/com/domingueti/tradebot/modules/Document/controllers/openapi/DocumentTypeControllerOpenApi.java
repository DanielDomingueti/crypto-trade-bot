package com.domingueti.tradebot.modules.Document.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeInsertDTO;
import com.domingueti.tradebot.modules.Document.dtos.DocumentTypePatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Document types")
public interface DocumentTypeControllerOpenApi {

	@ApiOperation("Fetch all document types")
	ResponseEntity<List<DocumentTypeDTO>> getDocumentTypes();

	@ApiOperation("Fetch document type by ID")
	ResponseEntity<DocumentTypeDTO> getDocumentTypeById(@ApiParam(value = "Document type ID", example = "1") Long id);

	@ApiOperation("Insert a new document type")
	ResponseEntity<DocumentTypeDTO> insertDocumentType(@ApiParam(value = "JSON body for document type") DocumentTypeInsertDTO dto);

	@ApiOperation("Delete a document by ID")
	ResponseEntity<Void> deleteDocumentTypeById(@ApiParam(value = "Document type ID", example = "1") Long id);

	@ApiOperation("Update a document by ID")
	ResponseEntity<DocumentTypeDTO> patchDocumentTypeById(@ApiParam(value = "Document type ID", example = "1")
			Long id, DocumentTypePatchDTO dto);

}