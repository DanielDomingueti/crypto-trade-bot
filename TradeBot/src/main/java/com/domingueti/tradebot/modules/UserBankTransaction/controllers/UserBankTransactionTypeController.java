package com.domingueti.tradebot.modules.UserBankTransaction.controllers;

import com.domingueti.tradebot.modules.UserBankTransaction.controllers.openapi.UserBankTransactionTypeControllerOpenApi;
import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionTypeDTO;
import com.domingueti.tradebot.modules.UserBankTransaction.services.types.GetUserBankTransactionTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/UserBankTransactionType", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserBankTransactionTypeController implements UserBankTransactionTypeControllerOpenApi {

	private GetUserBankTransactionTypesService getUserBankTransactionTypesService;
	
	@Override
	@GetMapping("/all")
	public ResponseEntity<List<UserBankTransactionTypeDTO>> getAllUserBankTransactionTypes() {
		
		List<UserBankTransactionTypeDTO> userBankTransactionTypes = getUserBankTransactionTypesService.execute();
		return ResponseEntity.ok().body(userBankTransactionTypes);
	}
	
}
