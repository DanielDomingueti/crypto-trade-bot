package com.domingueti.tradebot.modules.Document.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Document.dtos.DocumentTypeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Document types")
public interface DocumentTypeControllerOpenApi {

	@ApiOperation("Fetch all document types")
	ResponseEntity<List<DocumentTypeDTO>> getDocumentTypes();

}