package com.domingueti.tradebot.modules.Cryptocurrency.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class GetCryptocurrenciesService {

	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional(readOnly = true)
	public List<CryptocurrencyDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return cryptocurrencyRepository.findAll().stream()
				.map(CryptocurrencyDTO::new).toList();
	}
	
}
