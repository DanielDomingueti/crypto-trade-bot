package com.domingueti.tradebot.modules.CashBalance.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CashBalanceInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "User ID is mandatory")
	private @Getter @Setter Long userId;
	
	@NotNull(message = "Cash balance type ID is mandatory")
	private @Getter @Setter Long cashBalanceTypeId;
	
	@NotNull(message = "Value is mandatory")
	private @Getter @Setter BigDecimal value;
	
	@NotNull(message = "Simulated option is mandatory")
	private @Getter @Setter Boolean simulated;
}
