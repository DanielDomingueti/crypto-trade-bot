package com.domingueti.tradebot.modules.CashBalance.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.CashBalance.controllers.openapi.CashBalanceControllerOpenApi;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.services.GetCashBalanceByUserIdService;
import com.domingueti.tradebot.modules.CashBalance.services.GetCashBalancesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cashbalance", produces = MediaType.APPLICATION_JSON_VALUE)
public class CashBalanceController implements CashBalanceControllerOpenApi {

	private GetCashBalancesService getCashBalancesService;
	
	private GetCashBalanceByUserIdService getCashBalanceByUserIdService;
	
	@Override
	@GetMapping("/admin/all")
	public ResponseEntity<List<CashBalanceDTO>> getAllCashBalances() {
		
		List<CashBalanceDTO> cashBalances = getCashBalancesService.execute();
		return ResponseEntity.ok().body(cashBalances);
	}
	
	@Override
	@GetMapping("/{userId}")
	public ResponseEntity<CashBalanceDTO> getCashBalanceByUserId(@PathVariable Long userId) {
		
		CashBalanceDTO cashBalanceDTO = getCashBalanceByUserIdService.execute(userId);
		return ResponseEntity.ok().body(cashBalanceDTO);
	}
	
}
