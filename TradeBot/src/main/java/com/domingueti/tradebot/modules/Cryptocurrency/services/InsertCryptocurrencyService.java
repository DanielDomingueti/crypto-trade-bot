package com.domingueti.tradebot.modules.Cryptocurrency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyInsertDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class InsertCryptocurrencyService {

	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional
	public CryptocurrencyDTO execute(CryptocurrencyInsertDTO cryptocurrencyInsertDTO) {
//		validator(cryptocurrencyInsertDTO);
		
		Cryptocurrency cryptocurrency = new Cryptocurrency();
		copyDtoToModel(cryptocurrencyInsertDTO, cryptocurrency);
		
		cryptocurrency = cryptocurrencyRepository.save(cryptocurrency);
		
		return new CryptocurrencyDTO(cryptocurrency);
	}

	private void copyDtoToModel(CryptocurrencyInsertDTO dto, Cryptocurrency model) {
		model.setSymbol(dto.getSymbol());
		model.setName(dto.getName());
	}
	
}
