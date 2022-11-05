package com.domingueti.tradebot.modules.Cryptocurrency.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Cryptocurrency")
public interface CryptocurrencyControllerOpenApi {

	@ApiOperation("Fetch all cryptocurrencies")
	ResponseEntity<List<CryptocurrencyDTO>> getAllCryptocurrencies();

}