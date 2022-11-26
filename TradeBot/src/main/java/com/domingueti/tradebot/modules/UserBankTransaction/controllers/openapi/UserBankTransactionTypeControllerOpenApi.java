package com.domingueti.tradebot.modules.UserBankTransaction.controllers.openapi;

import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionTypeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "UserBankTransactionType")
public interface UserBankTransactionTypeControllerOpenApi {

	@ApiOperation("Fetch all bank transaction types")
	ResponseEntity<List<UserBankTransactionTypeDTO>> getAllUserBankTransactionTypes();
	
}