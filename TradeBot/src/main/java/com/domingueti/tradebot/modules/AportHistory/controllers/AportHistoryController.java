package com.domingueti.tradebot.modules.AportHistory.controllers;

import com.domingueti.tradebot.modules.AportHistory.dtos.AportHistoryDTO;
import com.domingueti.tradebot.modules.AportHistory.services.GetAportHistoryBetweenDatesService;
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
@RequestMapping(value = "/admin/aporthistory")
public class AportHistoryController {

	private GetAportHistoryBetweenDatesService getAportHistoryBetweenDatesService;

	@GetMapping
	public ResponseEntity<List<AportHistoryDTO>> getAportHistoryBetween(@RequestParam LocalDate initialDate,
																		@RequestParam LocalDate endDate) {
		//returns all trade history balances between dates
		return null;
	}

}
