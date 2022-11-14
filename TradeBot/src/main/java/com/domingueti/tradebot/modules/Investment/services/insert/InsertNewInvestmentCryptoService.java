package com.domingueti.tradebot.modules.Investment.services.insert;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertNewInvestmentCryptoService {

	@Transactional
	public InvestmentDTO execute(InvestmentInsertDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
