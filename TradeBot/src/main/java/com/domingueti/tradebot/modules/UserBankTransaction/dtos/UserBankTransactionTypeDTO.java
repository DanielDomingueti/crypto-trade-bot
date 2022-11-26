package com.domingueti.tradebot.modules.UserBankTransaction.dtos;

import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class UserBankTransactionTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String type;
	
	private @Getter @Setter String description;
	
	public UserBankTransactionTypeDTO(UserBankTransactionType model) {
		this.type = model.getType();
		this.description = model.getDescription();
	}

}
