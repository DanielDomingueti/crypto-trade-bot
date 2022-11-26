package com.domingueti.tradebot.modules.InvestmentBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

	@Positive
	@NotNull(message = "Amount of units is mandatory")
	private @Getter @Setter Double units;
	
	@Positive
	@NotNull(message = "Net balance is mandatory")
	private @Getter @Setter BigDecimal netValue;
	
	@NotNull(message = "Simulated option is mandatory")
	private @Getter @Setter Boolean simulated;

}
