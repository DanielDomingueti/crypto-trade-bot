package com.domingueti.tradebot.modules.CashBalance.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeInsertDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypePatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "CashBalanceType")
public interface CashBalanceTypeControllerOpenApi {

	@ApiOperation("Fetch all cash balance types")
	ResponseEntity<List<CashBalanceTypeDTO>> getAllCashBalanceTypes();
	
	@ApiOperation("Fetch cash balance type by ID")
	ResponseEntity<CashBalanceTypeDTO> getCashBalanceTypeById(@ApiParam(value = "Cash balance type ID", example = "1") Long id);
	
	@ApiOperation("Insert a new cash balance type")
	ResponseEntity<CashBalanceTypeDTO> insertCashBalanceType(@ApiParam(value = "JSON body for CashBalanceTypeInsertDTO", example = "1") CashBalanceTypeInsertDTO dto);
	
	@ApiOperation("Delete a cash balance type by ID")
	ResponseEntity<Void> deleteCashBalanceTypeById(@ApiParam(value = "Cash balance type ID", example = "1") Long id);
	
	@ApiOperation("Update a cash balance type")
	ResponseEntity<CashBalanceTypeDTO> patchCashBalanceTypeById(@ApiParam(value = "Cash balance type ID", example = "1")
		Long id, CashBalanceTypePatchDTO dto);

}