package com.domingueti.tradebot.modules.Investment.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.domingueti.tradebot.modules.Investment.models.Investment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class InvestmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;
	
	private @Getter @Setter Long userId;
	
	private @Getter @Setter BigDecimal initialValue;
	
	private @Getter @Setter BigDecimal unitValue;

	private @Getter @Setter Double units;

	private @Getter @Setter Boolean simulated;
	
	public InvestmentDTO(Investment investment) {
		this.id = investment.getId();
		this.userId = investment.getUserId();
		this.initialValue = investment.getInitialValue();
		this.unitValue = investment.getUnitValue();
		this.units = investment.getUnits();
		this.simulated = investment.getSimulated();
	}
	
}
