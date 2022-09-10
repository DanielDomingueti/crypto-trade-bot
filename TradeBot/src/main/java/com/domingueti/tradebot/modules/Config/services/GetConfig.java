package com.domingueti.tradebot.modules.Config.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domingueti.tradebot.modules.Config.dtos.ConfigDTO;
import com.domingueti.tradebot.modules.Config.repositories.ConfigRepository;

@Service
public class GetConfig {

	@Autowired
	private ConfigRepository repository;

	public List<ConfigDTO> execute() {
		return repository.findByDeletedAtIsNull();
	}

	public ConfigDTO execute(String name) {
		return repository.findByNameAndDeletedAtIsNull(name);
	}
}