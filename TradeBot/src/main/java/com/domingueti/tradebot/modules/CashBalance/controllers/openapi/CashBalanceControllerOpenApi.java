package com.domingueti.tradebot.modules.CashBalance.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "CashBalance")
public interface CashBalanceControllerOpenApi {

	@ApiOperation("Fetch all cash balances")
	ResponseEntity<List<CashBalanceDTO>> getAllCashBalances();

	@ApiOperation("Fetch cash balance by User ID")
	ResponseEntity<CashBalanceDTO> getCashBalanceByUserId(@ApiParam(value = "User ID", example = "1") Long userId);

}