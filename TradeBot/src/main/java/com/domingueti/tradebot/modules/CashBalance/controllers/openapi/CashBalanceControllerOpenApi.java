package com.domingueti.tradebot.modules.CashBalance.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceInsertDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalancePatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "CashBalance")
public interface CashBalanceControllerOpenApi {

	@ApiOperation("Fetch all cash balances")
	ResponseEntity<List<CashBalanceDTO>> getAllCashBalances();

	@ApiOperation("Fetch cash balance by ID")
	ResponseEntity<CashBalanceDTO> getCashBalanceById(@ApiParam(value = "Cash balance ID", example = "1") Long id);

	@ApiOperation("Insert new cash balance")
	ResponseEntity<CashBalanceDTO> insertCashBalance(@ApiParam(value = "JSON body for CashBalanceInsertDTO") CashBalanceInsertDTO dto);

	@ApiOperation("Delete a cash balance by ID")
	ResponseEntity<Void> deleteCashBalanceById(@ApiParam(value = "Cash balance ID", example = "1") Long id);

	@ApiOperation("Update a cash balance by ID")
	ResponseEntity<CashBalanceDTO> patchCashBalanceById(@ApiParam(value = "Cash balance ID", example = "1")
		Long id, CashBalancePatchDTO dto);

}