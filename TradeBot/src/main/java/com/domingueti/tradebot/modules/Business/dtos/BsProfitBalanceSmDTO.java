package com.domingueti.tradebot.modules.Business.dtos;

import com.domingueti.tradebot.modules.Business.models.BsProfitBalanceSm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class BsProfitBalanceSmDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter BigDecimal netValue;

	public BsProfitBalanceSmDTO(BsProfitBalanceSm model) {
		this.netValue = model.getNetValue();
	}

}