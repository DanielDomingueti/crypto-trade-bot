package com.domingueti.tradebot.modules.Investment.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domingueti.tradebot.modules.Investment.controllers.openapi.InvestmentControllerOpenApi;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertFiatDTO;
import com.domingueti.tradebot.modules.Investment.services.InsertInvestmentCryptoManagerService;
import com.domingueti.tradebot.modules.Investment.services.InsertInvestmentFiatManagerService;
import com.domingueti.tradebot.modules.Investment.services.get.GetInvestmentByIdService;
import com.domingueti.tradebot.modules.Investment.services.get.GetInvestmentsByUserIdService;
import com.domingueti.tradebot.modules.Investment.services.get.GetInvestmentsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/investments")
public class InvestmentController implements InvestmentControllerOpenApi {
	
	private GetInvestmentsService getInvestmentsService;
	
	private GetInvestmentsByUserIdService getInvestmentsByUserIdService;
	
	private GetInvestmentByIdService getInvestmentByIdService;
	
	private InsertInvestmentFiatManagerService insertInvestmentFiatManagerService;
	
	private InsertInvestmentCryptoManagerService insertInvestmentCryptoManagerService;
	
	@Override
	@GetMapping("/admin/all")
	public ResponseEntity<List<InvestmentDTO>> getInvestments() {
		List<InvestmentDTO> investments = getInvestmentsService.execute();
		return ResponseEntity.ok().body(investments);
	}
	
	@Override
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<InvestmentDTO>> getInvestmentsByUserId(@PathVariable Long userId) {
		List<InvestmentDTO> investments = getInvestmentsByUserIdService.execute(userId);
		return ResponseEntity.ok().body(investments);
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<InvestmentDTO> getInvestmentById(@PathVariable Long id) {
		InvestmentDTO investmentDTO = getInvestmentByIdService.execute(id);
		return ResponseEntity.ok().body(investmentDTO);
	}
	
	@Override
	@PostMapping("/insert/fiat")
	public ResponseEntity<InvestmentDTO> insertInvestmentFiat(@RequestBody InvestmentInsertFiatDTO dto) {
		InvestmentDTO investmentDTO = insertInvestmentFiatManagerService.execute(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(investmentDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(investmentDTO);
	}
	
	@Override
	@PostMapping("/insert/crypto")
	public ResponseEntity<InvestmentDTO> insertInvestmentCrypto(@RequestBody InvestmentInsertCryptoDTO dto) {
		InvestmentDTO investmentDTO = insertInvestmentCryptoManagerService.execute(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(investmentDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(investmentDTO);
	}
	
}
