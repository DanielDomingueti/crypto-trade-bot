package com.domingueti.tradebot.modules.UserBankTransaction.dtos;

import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class UserBankTransactionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter Long userId;
	
	private @Getter @Setter Long userBankTransactionTypeId;

	private @Getter @Setter BigDecimal value;
	
	public UserBankTransactionDTO(UserBankTransaction model) {
		this.userId = model.getUserId();
		this.userBankTransactionTypeId = model.getUserBankTransactionTypeId();
		this.value = model.getValue();
	}

}
