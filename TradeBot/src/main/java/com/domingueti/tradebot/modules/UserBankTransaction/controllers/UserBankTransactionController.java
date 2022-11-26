package com.domingueti.tradebot.modules.UserBankTransaction.controllers;

import com.domingueti.tradebot.modules.UserBankTransaction.controllers.openapi.UserBankTransactionControllerOpenApi;
import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionDTO;
import com.domingueti.tradebot.modules.UserBankTransaction.services.GetUserBankTransactionByUserIdService;
import com.domingueti.tradebot.modules.UserBankTransaction.services.GetUserBankTransactionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/bankTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserBankTransactionController implements UserBankTransactionControllerOpenApi {

	private GetUserBankTransactionsService getUserBankTransactionsService;
	
	private GetUserBankTransactionByUserIdService getUserBankTransactionByUserIdService;
	
	@Override
	@GetMapping("/admin/all")
	public ResponseEntity<List<UserBankTransactionDTO>> getAllUserBankTransactions() {
		
		List<UserBankTransactionDTO> UserBankTransactions = getUserBankTransactionsService.execute();
		return ResponseEntity.ok().body(UserBankTransactions);
	}
	
	@Override
	@GetMapping("/{userId}")
	public ResponseEntity<UserBankTransactionDTO> getUserBankTransactionByUserId(@PathVariable Long userId) {

		UserBankTransactionDTO UserBankTransactionDTO = getUserBankTransactionByUserIdService.execute(userId);
		return ResponseEntity.ok().body(UserBankTransactionDTO);
	}
	
}
