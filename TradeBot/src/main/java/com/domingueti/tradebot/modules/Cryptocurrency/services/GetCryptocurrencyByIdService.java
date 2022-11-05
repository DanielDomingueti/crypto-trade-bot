package com.domingueti.tradebot.modules.Cryptocurrency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class GetCryptocurrencyByIdService {

	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional(readOnly = true)
	public CryptocurrencyDTO execute(Long id) {
	
		Cryptocurrency cryptocurrency = cryptocurrencyRepository.findByIdAndDeletedAtIsNull(id);

		if (cryptocurrency == null) {
			throw new NotFoundException("Cryptocurrency not found with given ID: " + id + " while fetching.");
		}
		
		return new CryptocurrencyDTO(cryptocurrency);
		
	}
	
}
