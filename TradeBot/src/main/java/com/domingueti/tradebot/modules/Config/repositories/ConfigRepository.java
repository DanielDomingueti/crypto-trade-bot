package com.domingueti.tradebot.modules.Config.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domingueti.tradebot.modules.Config.dtos.ConfigDTO;
import com.domingueti.tradebot.modules.Config.models.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

	List<ConfigDTO> findByDeletedAtIsNull();
	
	ConfigDTO findByNameAndDeletedAtIsNull(String name);	
	
}