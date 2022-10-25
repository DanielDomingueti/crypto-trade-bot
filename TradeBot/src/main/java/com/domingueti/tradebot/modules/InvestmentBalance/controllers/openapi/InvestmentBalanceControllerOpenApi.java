package com.domingueti.tradebot.modules.InvestmentBalance.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalancePatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Investment balances")
public interface InvestmentBalanceControllerOpenApi {

	@ApiOperation("Fetch all investmenst balances")
	ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalances();

	@ApiOperation("Fetch all investment balances by User ID")
	ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalancesByUserId(@ApiParam(value = "User ID", example = "1") Long userId);

	@ApiOperation("Fetch investment balance by ID")
	ResponseEntity<InvestmentBalanceDTO> getInvestmentBalanceById(@ApiParam(value = "Investment ID", example = "1") Long id);

	@ApiOperation("Insert a new investment balance")
	ResponseEntity<InvestmentBalanceDTO> insertInvestmentBalance(@ApiParam(value = "JSON body for InvestmentInsertDTO") InvestmentBalanceInsertDTO dto);

	@ApiOperation("Delete an investment balance by ID")
	ResponseEntity<Void> deleteInvestmentBalanceById(@ApiParam(value = "Investment ID", example = "1") Long id);

	@ApiOperation("Update an investment balance by ID")
	ResponseEntity<InvestmentBalanceDTO> patchInvestmentBalanceById(@ApiParam(value = "Investment ID", example = "1") 
		Long id, InvestmentBalancePatchDTO dto);

}