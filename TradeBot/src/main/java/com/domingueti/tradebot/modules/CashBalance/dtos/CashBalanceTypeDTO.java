package com.domingueti.tradebot.modules.CashBalance.dtos;

import java.io.Serializable;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CashBalanceTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String type;
	
	private @Getter @Setter String description;
	
	public CashBalanceTypeDTO(CashBalanceType model) {
		this.type = model.getType();
		this.description = model.getDescription();
	}

}
