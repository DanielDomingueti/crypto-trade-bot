package com.domingueti.tradebot.modules.Cryptocurrency.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.Cryptocurrency.controllers.openapi.CryptocurrencyControllerOpenApi;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.services.GetCryptocurrenciesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cryptocurrencies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CryptocurrencyController implements CryptocurrencyControllerOpenApi {

	private GetCryptocurrenciesService getCryptocurrenciesService;
	
	@Override
	@GetMapping("/all")
	public ResponseEntity<List<CryptocurrencyDTO>> getAllCryptocurrencies() {
		
		List<CryptocurrencyDTO> cryptocurrencies = getCryptocurrenciesService.execute();
		return ResponseEntity.ok().body(cryptocurrencies);
	}
	
}
