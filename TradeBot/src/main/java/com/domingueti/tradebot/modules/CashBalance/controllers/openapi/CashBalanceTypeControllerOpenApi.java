package com.domingueti.tradebot.modules.CashBalance.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "CashBalanceType")
public interface CashBalanceTypeControllerOpenApi {

	@ApiOperation("Fetch all cash balance types")
	ResponseEntity<List<CashBalanceTypeDTO>> getAllCashBalanceTypes();
	
}