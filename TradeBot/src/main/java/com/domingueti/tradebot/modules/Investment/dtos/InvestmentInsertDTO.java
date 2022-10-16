package com.domingueti.tradebot.modules.Investment.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class InvestmentInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long userId;
	
	private @Getter @Setter Long cryptocurrencyId;

	private @Getter @Setter BigDecimal initialValue;

	private @Getter @Setter Boolean simulated;
	
}
