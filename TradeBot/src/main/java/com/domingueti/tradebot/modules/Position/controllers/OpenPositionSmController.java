package com.domingueti.tradebot.modules.Position.controllers;

import com.domingueti.tradebot.modules.Position.dtos.OpenPositionSmDTO;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionSmByPairIdService;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionSmRoesService;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionsSmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/admin/openPosition/simulation")
public class OpenPositionSmController {

	private GetOpenPositionsSmService getOpenPositionsService;
	private GetOpenPositionSmByPairIdService getOpenPositionByPairIdService;
	private GetOpenPositionSmRoesService getOpenPositionRoeService;

	@GetMapping
	public ResponseEntity<List<OpenPositionSmDTO>> getAllOpenPositionSimulations() {
		//returns all open position simulations
		return null;
	}

	@GetMapping("/pair/{pairSymbolId}")
	public ResponseEntity<List<OpenPositionSmDTO>> getOpenPositionSimulationsByPairId(@PathVariable Long pairSymbolId) {
		//returns open position simulation of a given pair ID
		return null;
	}

	@GetMapping("/roe")
	public ResponseEntity<List<OpenPositionSmDTO>> getOpenPositionSimulationRoes() {
		//returns the final ROE percentage of all open position simulations
		return null;
	}
	
}
