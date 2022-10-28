package com.domingueti.tradebot.modules.CashBalance.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceInsertDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalancePatchDTO;
import com.domingueti.tradebot.modules.CashBalance.services.DeleteCashBalanceByIdService;
import com.domingueti.tradebot.modules.CashBalance.services.GetCashBalanceByIdService;
import com.domingueti.tradebot.modules.CashBalance.services.GetCashBalancesService;
import com.domingueti.tradebot.modules.CashBalance.services.InsertCashBalanceService;
import com.domingueti.tradebot.modules.CashBalance.services.PatchCashBalanceByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cashbalance", produces = MediaType.APPLICATION_JSON_VALUE)
public class CashBalanceController {

	private GetCashBalancesService getCashBalancesService;
	
	private GetCashBalanceByIdService getCashBalanceByIdService;
	
	private InsertCashBalanceService insertCashBalanceService;
	
	private DeleteCashBalanceByIdService deleteCashBalanceByIdService;
	
	private PatchCashBalanceByIdService patchCashBalanceByIdService;
	
	@GetMapping("/admin/all")
	public ResponseEntity<List<CashBalanceDTO>> getAllCashBalances() {
		
		List<CashBalanceDTO> cashBalances = getCashBalancesService.execute();
		return ResponseEntity.ok().body(cashBalances);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CashBalanceDTO> getCashBalanceById(@PathVariable Long id) {
		
		CashBalanceDTO cashBalanceDTO = getCashBalanceByIdService.execute(id);
		return ResponseEntity.ok().body(cashBalanceDTO);
	}
	
	@PostMapping("/admin/insert")
	public ResponseEntity<CashBalanceDTO> insertCashBalance(@RequestBody CashBalanceInsertDTO dto) {
		
		CashBalanceDTO cashBalanceDTO = insertCashBalanceService.execute(dto);
		return ResponseEntity.ok().body(cashBalanceDTO);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<Void> deleteCashBalanceById(@PathVariable Long id) {
		
		deleteCashBalanceByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/admin/patch/{id}")
	public ResponseEntity<CashBalanceDTO> patchCashBalanceById(@PathVariable Long id, @RequestBody CashBalancePatchDTO dto) {
		
		CashBalanceDTO cashBalanceDTO = patchCashBalanceByIdService.execute(id, dto);
		return ResponseEntity.ok().body(cashBalanceDTO);
	}
	
}
