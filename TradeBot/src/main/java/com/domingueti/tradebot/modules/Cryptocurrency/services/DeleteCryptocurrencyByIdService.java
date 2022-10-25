package com.domingueti.tradebot.modules.Cryptocurrency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class DeleteCryptocurrencyByIdService {

	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		cryptocurrencyRepository.deleteById(id);
	}
	
}
