package com.domingueti.tradebot.modules.CashBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CashBalancePatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter BigDecimal value;

}
