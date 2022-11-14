package com.domingueti.tradebot.modules.Investment.services.insert;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertExistingInvestmentCryptoService {

	private InvestmentRepository investmentRepository;
	private InvestmentBalanceRepository investmentBalanceRepository;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertCryptoDTO dto) {
		Investment investment = investmentRepository.findByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getResultCryptocurrencyId(), dto.getSimulated());
		InvestmentBalance previousInvestmentBalance = investmentBalanceRepository.findByInvestmentIdAndDeletedAtIsNull(investment.getId());

	
		return new InvestmentDTO(investment);
	}

}
