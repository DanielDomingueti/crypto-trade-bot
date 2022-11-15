package com.domingueti.tradebot.modules.Investment.services.insert;

import com.domingueti.tradebot.modules.Investment.repositories.PivotInvestmentBalancesRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.models.PivotInvestmentBalances;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.Investment.dtos.InvestmentDTO;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;
import com.domingueti.tradebot.modules.InvestmentBalance.repositories.InvestmentBalanceRepository;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class InsertExistingInvestmentCryptoService {

	private InvestmentRepository investmentRepository;
	private InvestmentBalanceRepository investmentBalanceRepository;

	private PivotInvestmentBalancesRepository pivotInvestmentBalancesRepository;

	@Transactional
	public InvestmentDTO execute(InvestmentInsertCryptoDTO dto) {
		//Deletes the previous investment balance for source and result operations
		//Copies the data between source/result balances and change their values
		//Saves all four balances
		//Creates pivot between cash balances

		Investment sourceInvestment = investmentRepository.findByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getSourceCryptocurrencyId(), dto.getSimulated());
		InvestmentBalance sourceInvestmentBalance = investmentBalanceRepository.findByInvestmentIdAndDeletedAtIsNull(sourceInvestment.getId());
		InvestmentBalance sourceNewInvestmentBalance = new InvestmentBalance();
		copyBetweenSourceInvestmentBalance(sourceInvestmentBalance, sourceNewInvestmentBalance, dto);

		Investment resultInvestment = investmentRepository.findByUserIdAndCryptocurrencyIdAndSimulatedAndDeletedAtIsNull(dto.getUserId(), dto.getResultCryptocurrencyId(), dto.getSimulated());
		InvestmentBalance resultInvestmentBalance = investmentBalanceRepository.findByInvestmentIdAndDeletedAtIsNull(resultInvestment.getId());
		InvestmentBalance resultNewInvestmentBalance = new InvestmentBalance();
		copyBetweenResultInvestmentBalance(resultInvestmentBalance, resultNewInvestmentBalance, dto);

		PivotInvestmentBalances pivot = new PivotInvestmentBalances();
		copyInvestmentBalancesToPivot(sourceNewInvestmentBalance, resultNewInvestmentBalance, pivot, dto);

		investmentBalanceRepository.saveAll(Arrays.asList(sourceInvestmentBalance, sourceNewInvestmentBalance,
				resultInvestmentBalance, resultNewInvestmentBalance));

		pivotInvestmentBalancesRepository.save(pivot);

		return new InvestmentDTO(resultInvestment);
	}

	private void copyInvestmentBalancesToPivot(InvestmentBalance sourceNewInvestmentBalance, InvestmentBalance resultNewInvestmentBalance, PivotInvestmentBalances pivot, InvestmentInsertCryptoDTO dto) {
		pivot.setInvestmentOperationTypeId(4L);
		pivot.setValue(dto.getInitialValue());
		pivot.setSimulated(dto.getSimulated());
		pivot.setSourceInvestmentBalanceId(sourceNewInvestmentBalance.getId());
		pivot.setResultInvestmentBalanceId(resultNewInvestmentBalance.getId());
	}

	private void copyBetweenResultInvestmentBalance(InvestmentBalance resultInvestmentBalance, InvestmentBalance resultNewInvestmentBalance, InvestmentInsertCryptoDTO dto) {
		resultNewInvestmentBalance.setInvestmentId(resultInvestmentBalance.getInvestmentId());
		resultNewInvestmentBalance.setUnits(resultInvestmentBalance.getUnits());
		resultNewInvestmentBalance.setSimulated(resultInvestmentBalance.getSimulated());
		resultNewInvestmentBalance.setProfit(resultInvestmentBalance.getProfit());
		resultNewInvestmentBalance.setProfitable(resultInvestmentBalance.getProfitable());
		resultNewInvestmentBalance.setNetValue(resultInvestmentBalance.getNetValue().add(dto.getInitialValue()));
		resultNewInvestmentBalance.setAverageUnitValue(resultInvestmentBalance.getAverageUnitValue());
		resultNewInvestmentBalance.setReferenceDate(resultInvestmentBalance.getReferenceDate());
		resultInvestmentBalance.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
	}

	private void copyBetweenSourceInvestmentBalance(InvestmentBalance sourceInvestmentBalance, InvestmentBalance sourceNewInvestmentBalance, InvestmentInsertCryptoDTO dto) {
		sourceNewInvestmentBalance.setInvestmentId(sourceInvestmentBalance.getInvestmentId());
		sourceNewInvestmentBalance.setUnits(sourceInvestmentBalance.getUnits());
		sourceNewInvestmentBalance.setSimulated(sourceInvestmentBalance.getSimulated());
		sourceNewInvestmentBalance.setProfit(sourceInvestmentBalance.getProfit());
		sourceNewInvestmentBalance.setProfitable(sourceInvestmentBalance.getProfitable());
		sourceNewInvestmentBalance.setNetValue(sourceInvestmentBalance.getNetValue().subtract(dto.getInitialValue()));
		sourceNewInvestmentBalance.setAverageUnitValue(sourceInvestmentBalance.getAverageUnitValue());
		sourceNewInvestmentBalance.setReferenceDate(sourceInvestmentBalance.getReferenceDate());
		sourceInvestmentBalance.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
	}

}
