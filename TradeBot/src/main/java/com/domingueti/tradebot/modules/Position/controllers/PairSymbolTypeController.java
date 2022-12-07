package com.domingueti.tradebot.modules.Position.controllers;

import com.domingueti.tradebot.modules.Position.dtos.PairSymbolTypeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/pairSymbolType")
public class PairSymbolTypeController {

	private GetPairSymbolTypesService getPairSymbolTypesService;

	@GetMapping
	public ResponseEntity<List<PairSymbolTypeDTO>> getAllPairSymbolTypes() {
		//returns all pair symbol types
		return null;
	}

}