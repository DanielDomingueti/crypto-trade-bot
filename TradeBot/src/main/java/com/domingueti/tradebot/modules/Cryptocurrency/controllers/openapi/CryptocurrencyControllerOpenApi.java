package com.domingueti.tradebot.modules.Cryptocurrency.controllers.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyInsertDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyPatchDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Cryptocurrency")
public interface CryptocurrencyControllerOpenApi {

	@ApiOperation("Fetch all cryptocurrencies")
	ResponseEntity<List<CryptocurrencyDTO>> getAllCryptocurrencies();

	@ApiOperation("Fetch cryptocurrency by ID")
	ResponseEntity<CryptocurrencyDTO> getCryptocurrencyById(@ApiParam(value = "Cryptocurrency ID", example = "1") Long id);

	@ApiOperation("Insert a new cryptocurrency")
	ResponseEntity<CryptocurrencyDTO> insertCryptocurrency(@ApiParam(value = "JSON body for CryptocurrencyInsertDTO") CryptocurrencyInsertDTO dto);

	@ApiOperation("Delete a cryptocurrency by ID")
	ResponseEntity<Void> deleteCryptocurrencyById(@ApiParam(value = "Cryptocurrency ID", example = "1") Long id);

	@ApiOperation("Update a cryptocurrency by ID")
	ResponseEntity<CryptocurrencyDTO> patchCryptocurrencyById(@ApiParam(value = "Cryptocurrency ID", example = "1") 
		Long id, CryptocurrencyPatchDTO dto);

}