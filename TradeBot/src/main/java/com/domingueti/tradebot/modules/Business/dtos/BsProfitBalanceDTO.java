package com.domingueti.tradebot.modules.Business.dtos;

import com.domingueti.tradebot.modules.Business.models.BsProfitBalance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class BsProfitBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;

	private @Getter @Setter BigDecimal netValue;

	private @Getter @Setter LocalDate referenceDate;

	public BsProfitBalanceDTO(BsProfitBalance model) {
		this.id = model.getId() == null ? null : model.getId();
		this.netValue = model.getNetValue() == null ? null : model.getNetValue();
		this.referenceDate = model.getReferenceDate() == null ? null : model.getReferenceDate();
	}

}
