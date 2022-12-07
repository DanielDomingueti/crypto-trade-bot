package com.domingueti.tradebot.modules.TradeHistory.controllers;

import com.domingueti.tradebot.modules.TradeHistory.dtos.TradeHistoryDTO;
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
@RequestMapping(value = "/admin/tradeHistory")
public class TradeHistoryController {

	private GetTradeHistoryBalanceService getTradeHistoryBalanceService;
	private GetTradeHistoryProfitService getTradeHistoryProfitService ;
	private GetTradeHistoryLossService getTradeHistoryLossService;


	@GetMapping("/balance")
	public ResponseEntity<List<TradeHistoryDTO>> getTradeHistoryBalanceBetween(@RequestParam LocalDate initialDate,
																			   @RequestParam LocalDate endDate) {
		//returns all trade history balances between dates
		return null;
	}

	@GetMapping("/profit")
	public ResponseEntity<List<TradeHistoryDTO>> getTradeHistoryProfitBetween(@RequestParam LocalDate initialDate,
																						   @RequestParam LocalDate endDate) {
		//returns all trade history profits between dates
		return null;
	}

	@GetMapping("/loss")
	public ResponseEntity<List<TradeHistoryDTO>> getTradeHistoryLossesBetween(@RequestParam LocalDate initialDate,
																						   @RequestParam LocalDate endDate) {
		//returns all trade history losses between dates
		return null;
	}
}
