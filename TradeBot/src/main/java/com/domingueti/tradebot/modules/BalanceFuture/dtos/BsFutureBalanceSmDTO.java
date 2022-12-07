package com.domingueti.tradebot.modules.BalanceFuture.dtos;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalanceSm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class BsFutureBalanceSmDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Double units;

	public BsFutureBalanceSmDTO(BsFutureBalanceSm model) {
		this.units = model.getUnits();
	}
	
}
