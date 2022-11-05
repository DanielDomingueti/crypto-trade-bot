package com.domingueti.tradebot.modules.Cryptocurrency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class DeleteCryptocurrencyByIdService {

	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional
	public void execute(Long id) {
		
		Cryptocurrency cryptocurrency = cryptocurrencyRepository.findByIdAndDeletedAtIsNull(id);
		
//		validator.execute(cryptocurrency);
		
		if (cryptocurrency == null) {
			throw new NotFoundException("Cryptocurrency not found with given ID: " + id + " while deleting.");
		}

		cryptocurrencyRepository.deleteById(id);
	}
	
}
