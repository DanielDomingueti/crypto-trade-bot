package com.domingueti.tradebot.modules.Cryptocurrency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.dtos.CryptocurrencyPatchDTO;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;

@Service
public class PatchCryptocurrencyByIdService {

	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	@Transactional
	public CryptocurrencyDTO execute(Long id, CryptocurrencyPatchDTO cryptocurrencyDTO) {
		
		Cryptocurrency cryptocurrency = cryptocurrencyRepository.findByIdAndDeletedAtIsNull(id);

//		validator.execute(cryptocurrency);
		
		copyDtoToModel(cryptocurrencyDTO, cryptocurrency);
		
		cryptocurrency = cryptocurrencyRepository.save(cryptocurrency);
		
		return new CryptocurrencyDTO(cryptocurrency);
	}

	private void copyDtoToModel(CryptocurrencyPatchDTO dto, Cryptocurrency model) {
		model.setSymbol(dto.getSymbol() != null ? dto.getSymbol() : model.getSymbol());
		model.setName(dto.getName() != null ? dto.getName() : model.getName());
	}
	
}
