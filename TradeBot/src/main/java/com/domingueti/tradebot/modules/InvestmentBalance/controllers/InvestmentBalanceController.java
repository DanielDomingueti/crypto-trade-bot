package com.domingueti.tradebot.modules.InvestmentBalance.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalancePatchDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.services.DeleteInvestmentBalanceByIdService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.GetInvestmentBalanceByIdService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.GetInvestmentBalancesByUserIdService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.InsertInvestmentBalanceService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.PatchInvestmentBalanceByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/investmentBalance")
public class InvestmentBalanceController {

	private GetInvestmentBalancesByUserIdService getInvestmentBalancesByUserIdService;

	private GetInvestmentBalanceByIdService getInvestmentBalanceByIdService;
	
	private InsertInvestmentBalanceService insertInvestmentBalanceService;
	
	private DeleteInvestmentBalanceByIdService deleteInvestmentBalanceByIdService;
	
	private PatchInvestmentBalanceByIdService patchInvestmentBalanceByIdService;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalancesByUserId(@PathVariable Long userId) {
		List<InvestmentBalanceDTO> investmentBalances = getInvestmentBalancesByUserIdService.execute(userId);
		return ResponseEntity.ok().body(investmentBalances);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InvestmentBalanceDTO> getInvestmentBalanceById(@PathVariable Long id) {
		InvestmentBalanceDTO investmentBalanceDTO = getInvestmentBalanceByIdService.execute(id);
		return ResponseEntity.ok().body(investmentBalanceDTO);
	}
	
	@PostMapping
	public ResponseEntity<InvestmentBalanceDTO> insertInvestmentBalance(@RequestBody InvestmentBalanceInsertDTO dto) {
		InvestmentBalanceDTO investmentBalanceDTO = insertInvestmentBalanceService.execute(dto);
		return ResponseEntity.ok().body(investmentBalanceDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvestmentBalanceById(@PathVariable Long id) {
		deleteInvestmentBalanceByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<InvestmentBalanceDTO> patchInvestmentBalanceById(@PathVariable Long id, @RequestBody InvestmentBalancePatchDTO dto) {
		InvestmentBalanceDTO investmentBalanceDTO = patchInvestmentBalanceByIdService.execute(id, dto);
		return ResponseEntity.ok().body(investmentBalanceDTO);
	} 
	
}
