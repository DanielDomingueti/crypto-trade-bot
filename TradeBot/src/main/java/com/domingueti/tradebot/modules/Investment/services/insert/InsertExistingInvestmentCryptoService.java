package com.domingueti.tradebot.modules.Investment.services.insert;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class InsertExistingInvestmentCryptoService {

	private InvestmentRepository investmentRepository;

	@Transactional
	public InvestmentDTO execute(InvestmentInsertCryptoDTO dto) {
		//Deletes the previous investment balance for source and result operations
		//Copies the data between source/result balances and change their values
		//Saves all four balances
		//Creates pivot between cash balances



		return null;
	}

}
