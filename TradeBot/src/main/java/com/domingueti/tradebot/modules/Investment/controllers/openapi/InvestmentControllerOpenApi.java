package com.domingueti.tradebot.modules.Investment.controllers.openapi;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Investments")
public interface InvestmentControllerOpenApi {

	@ApiOperation("Fetch all investmensts")
	ResponseEntity<List<InvestmentDTO>> getInvestments();
	
	@ApiOperation("Fetch all investments by User ID")
	ResponseEntity<List<InvestmentDTO>> getInvestmentsByUserId(@ApiParam(value = "User ID", example = "1") Long userId);

	@ApiOperation("Fetch investment by ID")
	ResponseEntity<InvestmentDTO> getInvestmentById(@ApiParam(value = "Investment ID", example = "1") Long id);

	@ApiOperation("Insert a new investment through CRYPTO")
	ResponseEntity<InvestmentDTO> insertInvestmentCrypto(@ApiParam(value = "JSON body for InvestmentInsertCryptoDTO") InvestmentInsertCryptoDTO dto);
}