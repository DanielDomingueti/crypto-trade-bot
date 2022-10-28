package com.domingueti.tradebot.modules.Investment.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentPatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Investments")
public interface InvestmentControllerOpenApi {

	@ApiOperation("Fetch all investmensts")
	ResponseEntity<List<InvestmentDTO>> getInvestments();
	
	@ApiOperation("Fetch all investments by User ID")
	ResponseEntity<List<InvestmentDTO>> getInvestmentsByUserId(@ApiParam(value = "User ID", example = "1") Long userId);

	@ApiOperation("Fetch investment by ID")
	ResponseEntity<InvestmentDTO> getInvestmentById(@ApiParam(value = "Investment ID", example = "1") Long id);

	@ApiOperation("Insert a new investment")
	ResponseEntity<InvestmentDTO> insertInvestment(@ApiParam(value = "JSON body for InvestmentInsertDTO") InvestmentInsertDTO dto);

	@ApiOperation("Delete an investment by ID")
	ResponseEntity<Void> deleteInvestmentById(@ApiParam(value = "Investment ID", example = "1") Long id);

	@ApiOperation("Update an investment by ID")
	ResponseEntity<InvestmentDTO> patchInvestmentById(@ApiParam(value = "Investment ID", example = "1") 
		Long id, InvestmentPatchDTO dto);

}