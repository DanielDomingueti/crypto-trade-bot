package com.domingueti.tradebot.modules.Position.controllers;

import com.domingueti.tradebot.modules.Position.dtos.OpenPositionDTO;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionByPairIdService;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionRoesService;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/admin/openPosition")
public class OpenPositionController {

	private GetOpenPositionsService getOpenPositionsService;
	private GetOpenPositionByPairIdService getOpenPositionByPairIdService;
	private GetOpenPositionRoesService getOpenPositionRoeService;

	@GetMapping
	public ResponseEntity<List<OpenPositionDTO>> getAllOpenPositions() {
		//returns all open positions
		return null;
	}

	@GetMapping("/pair/{pairSymbolId}")
	public ResponseEntity<List<OpenPositionDTO>> getOpenPositionsByPairId(@PathVariable Long pairSymbolId) {
		//returns open position of a given pair ID
		return null;
	}

	@GetMapping("/roe")
	public ResponseEntity<List<OpenPositionDTO>> getOpenPositionRoes() {
		//returns the final ROE percentage of all open positions
		return null;
	}

//	@PostMapping
//	public ResponseEntity<OpenPositionDTO> insertPosition(OpenPositionInsertDTO) {
//
//	}
	
}
