package com.domingueti.tradebot.modules.Config.services;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.domingueti.tradebot.modules.Config.dtos.ConfigDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ConfigService {

    private GetConfig getConfig;
    
	public LocalDate getMigrationDate() {
		 ConfigDTO config = getConfig.execute("MIGRATION_DATE");
		
		return LocalDate.parse(config.getValue());
	}

}