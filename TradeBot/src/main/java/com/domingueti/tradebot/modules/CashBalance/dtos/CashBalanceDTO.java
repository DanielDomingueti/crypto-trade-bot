package com.domingueti.tradebot.modules.CashBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CashBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter Long userId;
	
	private @Getter @Setter Long cashBalanceTypeId;

	private @Getter @Setter BigDecimal value;
	
	private @Getter @Setter Boolean simulated;
	
	public CashBalanceDTO(CashBalance model) {
		this.userId = model.getUserId();
		this.cashBalanceTypeId = model.getCashBalanceTypeId();
		this.value = model.getValue();
		this.simulated = model.getSimulated();
	}

}
