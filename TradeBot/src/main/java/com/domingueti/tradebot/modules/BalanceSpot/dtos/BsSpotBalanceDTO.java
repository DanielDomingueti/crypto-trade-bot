package com.domingueti.tradebot.modules.BalanceSpot.dtos;

import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class BsSpotBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter BigDecimal netValue;

	private @Getter @Setter Double units;

	private @Getter @Setter BigDecimal profit;

	private @Getter @Setter LocalDate referenceDate;

	public BsSpotBalanceDTO(BsSpotBalance model) {
		this.netValue = model.getNetValue();
		this.units = model.getUnits();
		this.profit = model.getProfit();
		this.referenceDate = model.getReferenceDate();
	}
	
}
