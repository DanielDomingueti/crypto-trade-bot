package com.domingueti.tradebot.modules.TradeHistory.controllers;

import com.domingueti.tradebot.modules.TradeHistory.dtos.TradeHistorySmDTO;
import com.domingueti.tradebot.modules.TradeHistory.services.GetTradeHistorySmBalanceService;
import com.domingueti.tradebot.modules.TradeHistory.services.GetTradeHistorySmLossService;
import com.domingueti.tradebot.modules.TradeHistory.services.GetTradeHistorySmProfitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/admin/tradeHistory/sm")
public class TradeHistorySmController {

	private GetTradeHistorySmBalanceService getTradeHistorySmBalanceService;
	private GetTradeHistorySmProfitService getTradeHistorySmProfitService;
	private GetTradeHistorySmLossService getTradeHistorySmLossService;

	@GetMapping("/balance")
	public ResponseEntity<List<TradeHistorySmDTO>> getTradeHistorySimulationBalanceBetween(@RequestParam LocalDate initialDate,
																						   @RequestParam LocalDate endDate) {
		//returns all trade history simulation balances between dates
		return null;
	}

	@GetMapping("/profit")
	public ResponseEntity<List<TradeHistorySmDTO>> getTradeHistorySimulationProfitBetween(@RequestParam LocalDate initialDate,
																						   @RequestParam LocalDate endDate) {
		//returns all trade history simulation profits between dates
		return null;
	}

	@GetMapping("/loss")
	public ResponseEntity<List<TradeHistorySmDTO>> getTradeHistorySimulationLossesBetween(@RequestParam LocalDate initialDate,
																						   @RequestParam LocalDate endDate) {
		//returns all trade history simulation losses between dates
		return null;
	}
}
