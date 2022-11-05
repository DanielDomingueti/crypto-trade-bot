package com.domingueti.tradebot.modules.CashBalance.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.CashBalance.controllers.openapi.CashBalanceTypeControllerOpenApi;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.services.types.GetCashBalanceTypesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cashbalancetype", produces = MediaType.APPLICATION_JSON_VALUE)
public class CashBalanceTypeController implements CashBalanceTypeControllerOpenApi {

	private GetCashBalanceTypesService getCashBalanceTypesService;
	
	@Override
	@GetMapping("/all")
	public ResponseEntity<List<CashBalanceTypeDTO>> getAllCashBalanceTypes() {
		
		List<CashBalanceTypeDTO> cashBalanceTypeTypes = getCashBalanceTypesService.execute();
		return ResponseEntity.ok().body(cashBalanceTypeTypes);
	}
	
}
