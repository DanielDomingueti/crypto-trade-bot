package com.domingueti.tradebot.modules.Investment.services.insert;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceRepository;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertFiatDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalanceCashBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalances;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;
import com.domingueti.tradebot.modules.utils.statics.CalculateAverageUnitPrice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertExistingInvestmentFiatService {

	private InvestmentRepository investmentRepository;
	private InvestmentBalanceRepository investmentBalanceRepository;
	private CashBalanceRepository cashBalanceRepository;
	
	@Transactional
	public InvestmentDTO execute(InvestmentInsertFiatDTO dto) {
		
		Investment investment = investmentRepository.findByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getCryptocurrencyId(), dto.getSimulated());
		InvestmentBalance previousInvestmentBalance = investmentBalanceRepository.findByInvestmentIdAndDeletedAtIsNull(investment.getId());
		CashBalance previousCashBalance = cashBalanceRepository.findByUserIdAndDeletedAtIsNull(dto.getUserId());
		
		//delete X balance and create X+1 balance based on both values
		InvestmentBalance newBalance = new InvestmentBalance();
		copyDtoToModel(dto, investment, previousInvestmentBalance, newBalance);
		previousInvestmentBalance.setDeletedAt(Timestamp.valueOf(LocalDate.now().toString()));
		investmentBalanceRepository.saveAll(Arrays.asList(previousInvestmentBalance, newBalance));
		
		//delete X cashBalance and create X+1 cash balance based on both values
		CashBalance newCashBalance = new CashBalance();
		copyDtoToModel(dto, previousCashBalance, newCashBalance);
		previousCashBalance.setDeletedAt(Timestamp.valueOf(LocalDate.now().toString()));
		cashBalanceRepository.saveAll(Arrays.asList(previousCashBalance, newCashBalance));
		
		return new InvestmentDTO(investment);
	}
	
	private void copyDtoToModel(InvestmentInsertFiatDTO dto, CashBalance previousCashBalance, CashBalance newCashBalance) {
		newCashBalance.setUserId(dto.getUserId());
		newCashBalance.setCashBalanceTypeId(previousCashBalance.getCashBalanceTypeId());
		newCashBalance.setValue(previousCashBalance.getValue().subtract(dto.getInitialValue()));
		newCashBalance.setSimulated(previousCashBalance.getSimulated());
		newCashBalance.setUser(previousCashBalance.getUser());
		newCashBalance.setCashBalanceType(previousCashBalance.getCashBalanceType());
		
		for (PivotInvestmentBalanceCashBalance pivot : previousCashBalance.getPivotInvestmentBalancesCashBalances()) {
			newCashBalance.getPivotInvestmentBalancesCashBalances().add(pivot);
		}
	}

	private void copyDtoToModel(InvestmentInsertFiatDTO dto, Investment investment, InvestmentBalance lastBalance, InvestmentBalance newBalance) {
		Double liveCryptoValue = 1.0;
		Double newUnits = dto.getInitialValue().doubleValue() / liveCryptoValue;
		
		newBalance.setInvestmentId(investment.getId());
		newBalance.setNetValue(lastBalance.getNetValue().add(dto.getInitialValue())); //sum the last active investment balance with the new one
		newBalance.setUnits(lastBalance.getUnits() + newUnits); // sum last active units with new investment units
		newBalance.setAverageUnitValue(BigDecimal.valueOf(CalculateAverageUnitPrice.execute(lastBalance.getNetValue(), lastBalance.getUnits(), dto.getInitialValue(), newUnits)));
		newBalance.setProfit(lastBalance.getProfit());
		newBalance.setProfitable(lastBalance.getProfitable());
		newBalance.setSimulated(lastBalance.getSimulated());
		newBalance.setReferenceDate(lastBalance.getReferenceDate());
		newBalance.setInvestment(lastBalance.getInvestment());
		
		for (PivotInvestmentBalanceCashBalance pivot : lastBalance.getPivotInvestmentBalancesCashBalances()) {
			newBalance.getPivotInvestmentBalancesCashBalances().add(pivot);
		}
		
		for (PivotInvestmentBalances pivot : lastBalance.getSourcePivotInvestmentBalances()) {
			newBalance.getSourcePivotInvestmentBalances().add(pivot);
		}
		
		for (PivotInvestmentBalances pivot : lastBalance.getResultPivotInvestmentBalances()) {
			newBalance.getResultPivotInvestmentBalances().add(pivot);
		}
	}

}
