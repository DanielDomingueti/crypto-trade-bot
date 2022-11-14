package com.domingueti.tradebot.modules.Investment.dtos;

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
public class InvestmentInsertFiatDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "User ID is mandatory")
	private @Getter @Setter Long userId;

	@NotNull(message = "Cryptocurrency ID is mandatory")
	private @Getter @Setter Long cryptocurrencyId;

	@Positive
	@NotNull(message = "Initial value is mandatory")
	private @Getter @Setter BigDecimal initialValue;

	@NotNull(message = "Simulated option is mandatory")
	private @Getter @Setter Boolean simulated;
	
}
