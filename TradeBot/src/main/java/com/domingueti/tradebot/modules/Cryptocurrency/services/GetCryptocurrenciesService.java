package com.domingueti.tradebot.modules.Cryptocurrency.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class GetCryptocurrenciesService {

	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional(readOnly = true)
	public List<CryptocurrencyDTO> execute() {

		List<Cryptocurrency> cryptocurrencies = cryptocurrencyRepository.findAllByDeletedAtIsNull();
		
		return cryptocurrencies.stream().map(CryptocurrencyDTO::new).collect(Collectors.toList());
	}
	
}
