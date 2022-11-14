package com.domingueti.tradebot.modules.Investment.services.insert;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertFiatDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.validators.InsertInvestmentFiatValidator;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertNewInvestmentFiatService {

	private InvestmentRepository investmentRepository;
	private InvestmentBalanceRepository investmentBalanceRepository;
	private CashBalanceRepository cashBalanceRepository;
	private InsertInvestmentFiatValidator validator;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertFiatDTO dto) {
		validator.execute(dto);
		
		//Create a new investment
		Investment investment = new Investment();
		copyDtoToModel(dto, investment);
		investment = investmentRepository.save(investment);

		//Create a new investment balance
		InvestmentBalance investmentBalance = new InvestmentBalance();
		copyDtoToModel(dto, investmentBalance, investment);
		investmentBalance = investmentBalanceRepository.save(investmentBalance);
		
		//Updated cash balance 
		CashBalance currentCashBalance = cashBalanceRepository.findByUserIdAndDeletedAtIsNull(dto.getUserId());
		BigDecimal currentCashBalanceValue = currentCashBalance.getValue();
		currentCashBalance.setValue(currentCashBalanceValue.subtract(dto.getInitialValue()));
		cashBalanceRepository.save(currentCashBalance);
		
		return new InvestmentDTO(investment);
	}

	//VERIFICAR SE SALVARA O INVESTMENT E LISTS COMO REFERENCIA
	private void copyDtoToModel(InvestmentInsertFiatDTO dto, InvestmentBalance model, Investment investment) {
		model.setInvestmentId(investment.getId());
		model.setNetValue(dto.getInitialValue());
		model.setUnits(investment.getUnits());
		model.setAverageUnitValue(investment.getUnitValue());
		model.setProfit(new BigDecimal("0.0"));
		model.setProfitable(false);
		model.setSimulated(dto.getSimulated());
	}

	private void copyDtoToModel(InvestmentInsertFiatDTO dto, Investment model) {
		BigDecimal liveCryptoValue = new BigDecimal("1.0");
		
		model.setUserId(dto.getUserId());
		model.setActive(true);
		model.setCryptocurrencyId(dto.getCryptocurrencyId());
		model.setSimulated(dto.getSimulated());
		model.setInitialValue(dto.getInitialValue());
		model.setUnitValue(liveCryptoValue);
		model.setUnits(dto.getInitialValue().divide(liveCryptoValue).doubleValue());
		
	}

}
