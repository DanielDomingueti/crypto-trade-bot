package com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalanceSm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class BsFutureBalanceSmDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Double units;

	private @Getter @Setter LocalDate referenceDate;
	public BsFutureBalanceSmDTO(BsFutureBalanceSm model) {
		this.units = model.getUnits() == null ? null : model.getUnits();
		this.referenceDate = model.getReferenceDate() == null ? null : model.getReferenceDate();
	}

}