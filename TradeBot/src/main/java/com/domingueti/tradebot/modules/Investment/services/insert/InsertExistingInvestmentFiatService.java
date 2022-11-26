package com.domingueti.tradebot.modules.Investment.services.insert;

import com.domingueti.tradebot.modules.UserBankTransaction.models.CashBalance;
import com.domingueti.tradebot.modules.UserBankTransaction.repositories.CashBalanceRepository;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertFiatDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.Investment.repositories.PivotInvestmentBalanceCashBalanceRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalanceCashBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalances;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;
import com.domingueti.tradebot.modules.utils.statics.CalculateAverageUnitPrice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class InsertExistingInvestmentFiatService {

	private InvestmentRepository investmentRepository;
	private InvestmentBalanceRepository investmentBalanceRepository;
	private CashBalanceRepository cashBalanceRepository;
	private PivotInvestmentBalanceCashBalanceRepository pivotInvestmentBalanceCashBalanceRepository;

	@Transactional
	public InvestmentDTO execute(InvestmentInsertFiatDTO dto) {

		Investment investment = investmentRepository.findByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getCryptocurrencyId(), dto.getSimulated());

		//delete X balance and create X+1 balance based on both values
		InvestmentBalance previousInvestmentBalance = investmentBalanceRepository.findByInvestmentIdAndDeletedAtIsNull(investment.getId());
		InvestmentBalance newInvestmentBalance = new InvestmentBalance();
		copyDtoToModel(dto, investment, previousInvestmentBalance, newInvestmentBalance);
		previousInvestmentBalance.setDeletedAt(Timestamp.valueOf(LocalDate.now().toString()));
		investmentBalanceRepository.saveAll(Arrays.asList(previousInvestmentBalance, newInvestmentBalance));
		
		//delete X cashBalance and create X+1 cash balance based on both values
		CashBalance previousCashBalance = cashBalanceRepository.findByUserIdAndDeletedAtIsNull(dto.getUserId());
		CashBalance newCashBalance = new CashBalance();
		copyPreviousToNewCashBalance(dto, previousCashBalance, newCashBalance);
		previousCashBalance.setDeletedAt(Timestamp.valueOf(LocalDate.now().toString()));
		cashBalanceRepository.saveAll(Arrays.asList(previousCashBalance, newCashBalance));

		//Saves pivot between cash balance and investment balance
		PivotInvestmentBalanceCashBalance pivot = new PivotInvestmentBalanceCashBalance();
		copyInvestmentBalanceAndCashBalanceToPivot(pivot, newInvestmentBalance, newCashBalance, dto);
		pivotInvestmentBalanceCashBalanceRepository.save(pivot);

		return new InvestmentDTO(investment);
	}

	private void copyInvestmentBalanceAndCashBalanceToPivot(PivotInvestmentBalanceCashBalance pivot, InvestmentBalance newBalance, CashBalance newCashBalance, InvestmentInsertFiatDTO dto) {
		pivot.setInvestmentBalanceId(newBalance.getId());
		pivot.setCashBalanceId(newCashBalance.getId());
		pivot.setInvestmentOperationTypeId(2L);
		pivot.setSimulated(dto.getSimulated());
		pivot.setValue(dto.getInitialValue());
	}
	
	private void copyPreviousToNewCashBalance(InvestmentInsertFiatDTO dto, CashBalance previousCashBalance, CashBalance newCashBalance) {
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
