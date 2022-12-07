package com.domingueti.tradebot.modules.BalanceFuture.dtos;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class BsFutureBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Double units;

	public BsFutureBalanceDTO(BsFutureBalance model) {
		this.units = model.getUnits();
	}
	
}
