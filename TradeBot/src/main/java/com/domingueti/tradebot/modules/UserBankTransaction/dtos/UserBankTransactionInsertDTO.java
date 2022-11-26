package com.domingueti.tradebot.modules.UserBankTransaction.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class UserBankTransactionInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "User ID is mandatory")
	private @Getter @Setter Long userId;
	
	@NotNull(message = "Bank transaction type ID is mandatory")
	private @Getter @Setter Long userBankTransactionTypeId;
	
	@NotNull(message = "Value is mandatory")
	private @Getter @Setter BigDecimal value;
	
}
