package com.domingueti.tradebot.modules.BalanceSpot.dtos;

import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class SpotBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter BigDecimal netValue;

	private @Getter @Setter Double units;

	private @Getter @Setter BigDecimal profit;

	public SpotBalanceDTO(SpotBalance model) {
		this.netValue = model.getNetValue();
		this.units = model.getUnits();
		this.profit = model.getProfit();
	}
	
}
