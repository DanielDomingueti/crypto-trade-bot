package com.domingueti.tradebot.modules.Cryptocurrency.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.Cryptocurrency.controllers.openapi.CryptocurrencyControllerOpenApi;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyInsertDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyPatchDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.services.DeleteCryptocurrencyByIdService;
import com.domingueti.tradebot.modules.Cryptocurrency.services.GetCryptocurrenciesService;
import com.domingueti.tradebot.modules.Cryptocurrency.services.GetCryptocurrencyByIdService;
import com.domingueti.tradebot.modules.Cryptocurrency.services.InsertCryptocurrencyService;
import com.domingueti.tradebot.modules.Cryptocurrency.services.PatchCryptocurrencyByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cryptocurrencies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CryptocurrencyController implements CryptocurrencyControllerOpenApi {

	private GetCryptocurrenciesService getCryptocurrenciesService;
	
	private GetCryptocurrencyByIdService getCryptocurrencyByIdService;
	
	private InsertCryptocurrencyService insertCryptocurrencyService;
	
	private DeleteCryptocurrencyByIdService deleteCryptocurrencyByIdService;
	
	private PatchCryptocurrencyByIdService patchCryptocurrencyByIdService;
	
	@Override
	@GetMapping
	public ResponseEntity<List<CryptocurrencyDTO>> getAllCryptocurrencies() {
		
		List<CryptocurrencyDTO> cryptocurrencies = getCryptocurrenciesService.execute();
		return ResponseEntity.ok().body(cryptocurrencies);
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<CryptocurrencyDTO> getCryptocurrencyById(@PathVariable Long id) {
		
		CryptocurrencyDTO cryptocurrencyDTO = getCryptocurrencyByIdService.execute(id);
		return ResponseEntity.ok().body(cryptocurrencyDTO);
	}
	
	@Override
	@PostMapping
	public ResponseEntity<CryptocurrencyDTO> insertCryptocurrency(@RequestBody CryptocurrencyInsertDTO dto) {
		
		CryptocurrencyDTO cryptocurrencyDTO = insertCryptocurrencyService.execute(dto);
		return ResponseEntity.ok().body(cryptocurrencyDTO);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCryptocurrencyById(@PathVariable Long id) {
		
		deleteCryptocurrencyByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@PatchMapping("/{id}")
	public ResponseEntity<CryptocurrencyDTO> patchCryptocurrencyById(@PathVariable Long id, @RequestBody CryptocurrencyPatchDTO dto) {
		
		CryptocurrencyDTO cryptocurrencyDTO = patchCryptocurrencyByIdService.execute(id, dto);
		return ResponseEntity.ok().body(cryptocurrencyDTO);
	}
	
}
