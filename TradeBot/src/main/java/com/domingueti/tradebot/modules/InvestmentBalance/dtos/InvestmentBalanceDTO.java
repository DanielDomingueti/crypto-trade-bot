package com.domingueti.tradebot.modules.InvestmentBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.domingueti.tradebot.modules.InvestmentBalance.models.InvestmentBalance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class InvestmentBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;
	
	private @Getter @Setter Long investmentId;

	private @Getter @Setter Double units;
	
	private @Getter @Setter BigDecimal netValue;
	
	private @Getter @Setter BigDecimal averageUnitValue;
	
	private @Getter @Setter BigDecimal profit;
	
	private @Getter @Setter Boolean profitable;
	
	private @Getter @Setter Boolean simulated;
	
	public InvestmentBalanceDTO(InvestmentBalance model) {
		id = model.getId();
		investmentId = model.getInvestmentId();
		netValue = model.getNetValue();
		units = model.getUnits();
		averageUnitValue = model.getAverageUnitValue();
		profit = model.getProfit();
		profitable = model.getProfitable();
		simulated = model.getSimulated();
	}
	
}
