package com.domingueti.tradebot.modules.TradeHistory.dtos;

import com.domingueti.tradebot.modules.TradeHistory.models.TradeHistorySm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class TradeHistorySmDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long openPositionSimulationId;

	private @Getter @Setter BigDecimal price;

	private @Getter @Setter BigDecimal size;

	private @Getter @Setter Double roe;

	private @Getter @Setter LocalDate referenceDate;

	public TradeHistorySmDTO(TradeHistorySm model) {
		this.openPositionSimulationId = model.getOpenPositionSimulationId();
		this.price = model.getPrice();
		this.size = model.getSize();
		this.roe = model.getRoe();
		this.referenceDate = model.getReferenceDate();
	}
}
