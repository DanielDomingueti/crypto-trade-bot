package com.domingueti.tradebot.modules.Cryptocurrency.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {

	Cryptocurrency findByIdAndDeletedAtIsNull(Long id);
	
	List<Cryptocurrency> findAllByDeletedAtIsNull();

}
