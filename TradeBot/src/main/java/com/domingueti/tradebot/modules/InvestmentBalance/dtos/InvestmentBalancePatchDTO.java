package com.domingueti.tradebot.modules.InvestmentBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class InvestmentBalancePatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter BigDecimal netValue;
	
	private @Getter @Setter Double units;
	
}
