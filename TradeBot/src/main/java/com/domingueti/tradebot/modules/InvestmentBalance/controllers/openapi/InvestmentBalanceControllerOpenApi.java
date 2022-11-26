package com.domingueti.tradebot.modules.InvestmentBalance.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Investment balances")
public interface InvestmentBalanceControllerOpenApi {

	@ApiOperation("Fetch all investmenst balances")
	ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalances();

	@ApiOperation("Fetch all investment balances by User ID")
	ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalancesByUserId(@ApiParam(value = "User ID", example = "1") Long userId);

	@ApiOperation("Fetch investment balance by investment ID")
	ResponseEntity<InvestmentBalanceDTO> getInvestmentBalanceByInvestmentId(@ApiParam(value = "Investment ID", example = "1") Long investmentId);

	@ApiOperation("Insert a new investment balance")
	ResponseEntity<InvestmentBalanceDTO> insertInvestmentBalance(@ApiParam(value = "JSON body for InvestmentInsertDTO") InvestmentBalanceInsertDTO dto);

}