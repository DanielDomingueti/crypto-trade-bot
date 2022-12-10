package com.domingueti.tradebot.modules.Position.controllers;

import com.domingueti.tradebot.modules.Position.dtos.OpenPositionTypeDTO;
import com.domingueti.tradebot.modules.Position.services.GetOpenPositionTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/openpositiontype")
public class OpenPositionTypeController {

	private GetOpenPositionTypesService getOpenPositionTypesService;

	@GetMapping("/all")
	public ResponseEntity<List<OpenPositionTypeDTO>> getAllOpenPositionTypes() {
		//returns all open position types
		return null;
	}

}
