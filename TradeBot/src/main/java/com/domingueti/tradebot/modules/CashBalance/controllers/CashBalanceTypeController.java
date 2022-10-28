package com.domingueti.tradebot.modules.CashBalance.controllers;

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

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeInsertDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypePatchDTO;
import com.domingueti.tradebot.modules.CashBalance.services.types.DeleteCashBalanceTypeByIdService;
import com.domingueti.tradebot.modules.CashBalance.services.types.GetCashBalanceTypeByIdService;
import com.domingueti.tradebot.modules.CashBalance.services.types.GetCashBalanceTypesService;
import com.domingueti.tradebot.modules.CashBalance.services.types.InsertCashBalanceTypeService;
import com.domingueti.tradebot.modules.CashBalance.services.types.PatchCashBalanceTypeByIdService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cashbalancetype", produces = MediaType.APPLICATION_JSON_VALUE)
public class CashBalanceTypeController {

	private GetCashBalanceTypesService getCashBalanceTypesService;
	
	private GetCashBalanceTypeByIdService getCashBalanceTypeByIdService;
	
	private InsertCashBalanceTypeService insertCashBalanceTypeService;
	
	private DeleteCashBalanceTypeByIdService deleteCashBalanceTypeByIdService;
	
	private PatchCashBalanceTypeByIdService patchCashBalanceTypeByIdService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CashBalanceTypeDTO>> getAllCashBalanceTypes() {
		
		List<CashBalanceTypeDTO> cashBalanceTypeTypes = getCashBalanceTypesService.execute();
		return ResponseEntity.ok().body(cashBalanceTypeTypes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CashBalanceTypeDTO> getCashBalanceTypeById(@PathVariable Long id) {
		
		CashBalanceTypeDTO cashBalanceTypeDTO = getCashBalanceTypeByIdService.execute(id);
		return ResponseEntity.ok().body(cashBalanceTypeDTO);
	}
	
	@PostMapping("/admin/insert")
	public ResponseEntity<CashBalanceTypeDTO> insertCashBalanceType(@RequestBody CashBalanceTypeInsertDTO dto) {
		
		CashBalanceTypeDTO cashBalanceTypeDTO = insertCashBalanceTypeService.execute(dto);
		return ResponseEntity.ok().body(cashBalanceTypeDTO);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<Void> deleteCashBalanceTypeById(@PathVariable Long id) {
		
		deleteCashBalanceTypeByIdService.execute(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/admin/patch/{id}")
	public ResponseEntity<CashBalanceTypeDTO> patchCashBalanceTypeById(@PathVariable Long id, @RequestBody CashBalanceTypePatchDTO dto) {
		
		CashBalanceTypeDTO cashBalanceTypeDTO = patchCashBalanceTypeByIdService.execute(id, dto);
		return ResponseEntity.ok().body(cashBalanceTypeDTO);
	}
	
}
