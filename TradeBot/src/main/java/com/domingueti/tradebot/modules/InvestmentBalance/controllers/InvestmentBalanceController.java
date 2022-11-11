package com.domingueti.tradebot.modules.InvestmentBalance.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.InvestmentBalance.controllers.openapi.InvestmentBalanceControllerOpenApi;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;
import com.domingueti.tradebot.modules.InvestmentBalance.services.GetInvestmentBalanceByIdService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.GetInvestmentBalancesByUserIdService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.GetInvestmentBalancesService;
import com.domingueti.tradebot.modules.InvestmentBalance.services.InsertInvestmentBalanceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/investmentbalances")
public class InvestmentBalanceController implements InvestmentBalanceControllerOpenApi {
	
	private GetInvestmentBalancesService getInvestmentBalancesService;

	private GetInvestmentBalancesByUserIdService getInvestmentBalancesByUserIdService;

	private GetInvestmentBalanceByIdService getInvestmentBalanceByIdService;
	
	private InsertInvestmentBalanceService insertInvestmentBalanceService;
	
	@Override
	@GetMapping("/admin/all")
	public ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalances() {
		List<InvestmentBalanceDTO> investmentBalances = getInvestmentBalancesService.execute();
		return ResponseEntity.ok().body(investmentBalances);
	}
	
	@Override
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<InvestmentBalanceDTO>> getInvestmentBalancesByUserId(@PathVariable Long userId) {
		List<InvestmentBalanceDTO> investmentBalances = getInvestmentBalancesByUserIdService.execute(userId);
		return ResponseEntity.ok().body(investmentBalances);
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<InvestmentBalanceDTO> getInvestmentBalanceById(@PathVariable Long id) {
		InvestmentBalanceDTO investmentBalanceDTO = getInvestmentBalanceByIdService.execute(id);
		return ResponseEntity.ok().body(investmentBalanceDTO);
	}
	
	@Override
	@PostMapping("/admin/insert")
	public ResponseEntity<InvestmentBalanceDTO> insertInvestmentBalance(@RequestBody InvestmentBalanceInsertDTO dto) {
		InvestmentBalanceDTO investmentBalanceDTO = insertInvestmentBalanceService.execute(dto);
		return ResponseEntity.ok().body(investmentBalanceDTO);
	}
	
}
