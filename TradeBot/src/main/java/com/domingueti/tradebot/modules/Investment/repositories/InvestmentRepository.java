package com.domingueti.tradebot.modules.Investment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Investment.models.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long>{

}
