package com.domingueti.tradebot.modules.Investment.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.tradebot.modules.Investment.controllers.openapi.InvestmentControllerOpenApi;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentPatchDTO;
import com.domingueti.tradebot.modules.Investment.services.DeleteInvestmentByIdService;
import com.domingueti.tradebot.modules.Investment.services.GetInvestmentByIdService;
import com.domingueti.tradebot.modules.Investment.services.GetInvestmentsByUserIdService;
import com.domingueti.tradebot.modules.Investment.services.GetInvestmentsService;
import com.domingueti.tradebot.modules.Investment.services.InsertInvestmentService;
import com.domingueti.tradebot.modules.Investment.services.PatchInvestmentByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/investments")
public class InvestmentController implements InvestmentControllerOpenApi {
	
	private GetInvestmentsService getInvestmentsService;
	
	private GetInvestmentsByUserIdService getInvestmentsByUserIdService;
	
	private GetInvestmentByIdService getInvestmentByIdService;
	
	private InsertInvestmentService insertInvestmentService;
	
	private DeleteInvestmentByIdService deleteInvestmentByIdService;
	
	private PatchInvestmentByIdService patchInvestmentByIdService;

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
	@PostMapping("/insert")
	public ResponseEntity<InvestmentDTO> insertInvestment(@RequestBody InvestmentInsertDTO dto) {
		InvestmentDTO investmentDTO = insertInvestmentService.execute(dto);
		return ResponseEntity.ok().body(investmentDTO);
	}
	
	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteInvestmentById(@PathVariable Long id) {
		deleteInvestmentByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@PatchMapping("/admin/patch/{id}")
	public ResponseEntity<InvestmentDTO> patchInvestmentById(@PathVariable Long id, @RequestBody InvestmentPatchDTO dto) {
		InvestmentDTO investmentDTO = patchInvestmentByIdService.execute(id, dto);
		return ResponseEntity.ok().body(investmentDTO);
	}
	
}
