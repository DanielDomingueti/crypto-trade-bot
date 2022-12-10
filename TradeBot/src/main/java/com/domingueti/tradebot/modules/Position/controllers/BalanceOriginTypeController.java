package com.domingueti.tradebot.modules.Position.controllers;

import com.domingueti.tradebot.modules.Position.dtos.BalanceOriginTypeDTO;
import com.domingueti.tradebot.modules.Position.services.GetBalanceOriginTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/balanceorigintype")
public class BalanceOriginTypeController {

	private GetBalanceOriginTypesService getBalanceOriginTypesService;

	@GetMapping("all")
	public ResponseEntity<List<BalanceOriginTypeDTO>> getAllBalanceOriginTypes() {
		//returns all balance origin types
		return null;
	}

}
