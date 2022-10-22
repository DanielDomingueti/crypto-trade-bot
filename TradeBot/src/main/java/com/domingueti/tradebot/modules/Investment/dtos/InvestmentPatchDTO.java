package com.domingueti.tradebot.modules.Investment.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class InvestmentPatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter BigDecimal initialValue;

	private @Getter @Setter BigDecimal unitValue;
	
	private @Getter @Setter Boolean active;
}
