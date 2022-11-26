package com.domingueti.tradebot.modules.Investment.services.insert;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertFiatDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.repositories.PivotInvestmentBalanceCashBalanceRepository;
import com.domingueti.tradebot.modules.Investment.validators.InsertInvestmentFiatValidator;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalanceCashBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class InsertNewInvestmentFiatService {

	private InvestmentRepository investmentRepository;
	private InvestmentBalanceRepository investmentBalanceRepository;
	private CashBalanceRepository cashBalanceRepository;
	private InsertInvestmentFiatValidator validator;
	private PivotInvestmentBalanceCashBalanceRepository pivotInvestmentBalanceCashBalanceRepository;

	@Transactional
	public InvestmentDTO execute(InvestmentInsertFiatDTO dto) {
		validator.execute(dto);
		
		//Create a new investment
		Investment investment = new Investment();
		copyDtoToModel(dto, investment);
		investment = investmentRepository.save(investment);

		//Create a new investment balance
		InvestmentBalance newInvestmentBalance = new InvestmentBalance();
		copyDtoToModel(dto, newInvestmentBalance, investment);
		newInvestmentBalance = investmentBalanceRepository.save(newInvestmentBalance);
		
		//Delete previous cash balance
		CashBalance previousCashBalance = cashBalanceRepository.findByUserIdAndDeletedAtIsNull(dto.getUserId());
		previousCashBalance.setDeletedAt(Timestamp.valueOf(String.valueOf(LocalDate.now())));
		//Create and populate new cash balance
		CashBalance newCashBalance = new CashBalance();
		copyPreviousToNewCashBalance(previousCashBalance, newCashBalance, dto);
		//Save both cash balances
		cashBalanceRepository.saveAll(Arrays.asList(previousCashBalance, newCashBalance));

		//Saves pivot between cash balance and investment balance
		PivotInvestmentBalanceCashBalance pivot = new PivotInvestmentBalanceCashBalance();
		copyInvestmentBalanceAndCashBalanceToPivot(pivot, newInvestmentBalance, newCashBalance, dto);
		pivot = pivotInvestmentBalanceCashBalanceRepository.save(pivot);

		return new InvestmentDTO(investment);
	}

	private void copyPreviousToNewCashBalance(CashBalance previousCashBalance, CashBalance newCashBalance, InvestmentInsertFiatDTO dto) {
		newCashBalance.setUserId(previousCashBalance.getUserId());
		newCashBalance.setCashBalanceTypeId(previousCashBalance.getCashBalanceTypeId());
		newCashBalance.setSimulated(previousCashBalance.getSimulated());
		newCashBalance.setValue(previousCashBalance.getValue().subtract(dto.getInitialValue()));
	}

	private void copyInvestmentBalanceAndCashBalanceToPivot(PivotInvestmentBalanceCashBalance pivot, InvestmentBalance newBalance, CashBalance newCashBalance, InvestmentInsertFiatDTO dto) {
		pivot.setInvestmentBalanceId(newBalance.getId());
		pivot.setCashBalanceId(newCashBalance.getId());
		pivot.setInvestmentOperationTypeId(1L);
		pivot.setSimulated(dto.getSimulated());
		pivot.setValue(dto.getInitialValue());
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
