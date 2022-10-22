package com.domingueti.tradebot.modules.InvestmentBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class InvestmentBalanceInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Investment ID is mandatory")
	private @Getter @Setter Long investmentId;

	@NotNull(message = "Amount of units is mandatory")
	private @Getter @Setter Double units;
	
	@NotNull(message = "Net balance is mandatory")
	private @Getter @Setter BigDecimal netValue;
	
	@NotNull(message = "Simulated option is mandatory")
	private @Getter @Setter Boolean simulated;

}
