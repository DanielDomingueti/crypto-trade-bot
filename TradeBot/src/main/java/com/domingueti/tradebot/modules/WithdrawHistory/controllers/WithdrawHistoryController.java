package com.domingueti.tradebot.modules.WithdrawHistory.controllers;

import com.domingueti.tradebot.modules.WithdrawHistory.dtos.WithdrawHistoryDTO;
import com.domingueti.tradebot.modules.WithdrawHistory.services.GetWithdrawHistoryBetweenDatesService;
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
@RequestMapping(value = "/admin/withdrawhistory")
public class WithdrawHistoryController {

	private GetWithdrawHistoryBetweenDatesService getWithdrawHistoryBetweenDatesService;

	@GetMapping
	public ResponseEntity<List<WithdrawHistoryDTO>> getWithdrawHistoryBetween(@RequestParam LocalDate initialDate,
																			  @RequestParam LocalDate endDate) {
		//returns all trade history balances between dates
		return null;
	}

}
