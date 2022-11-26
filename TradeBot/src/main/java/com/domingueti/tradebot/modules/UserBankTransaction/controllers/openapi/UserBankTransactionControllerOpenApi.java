package com.domingueti.tradebot.modules.UserBankTransaction.controllers.openapi;

import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "UserBankTransaction")
public interface UserBankTransactionControllerOpenApi {

	@ApiOperation("Fetch all bank transactions")
	ResponseEntity<List<UserBankTransactionDTO>> getAllUserBankTransactions();

	@ApiOperation("Fetch bank transaction by User ID")
	ResponseEntity<UserBankTransactionDTO> getUserBankTransactionByUserId(@ApiParam(value = "User ID", example = "1") Long userId);

}