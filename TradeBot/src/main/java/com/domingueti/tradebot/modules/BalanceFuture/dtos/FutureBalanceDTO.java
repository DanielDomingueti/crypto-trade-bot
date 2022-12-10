package com.domingueti.tradebot.modules.BalanceFuture.dtos;

import com.domingueti.tradebot.modules.BalanceFuture.models.FutureBalance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class FutureBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter BigDecimal netValue;

	private @Getter @Setter Double units;

	private @Getter @Setter BigDecimal profit;

	private @Getter @Setter LocalDate referenceDate;

	public FutureBalanceDTO(FutureBalance model) {
		this.netValue = model.getNetValue() == null ? null : model.getNetValue();
		this.units = model.getUnits() == null ? null : model.getUnits();
		this.profit = model.getProfit() == null ? null : model.getProfit();
		this.referenceDate = model.getReferenceDate() == null ? null : model.getReferenceDate();
	}
	
}
