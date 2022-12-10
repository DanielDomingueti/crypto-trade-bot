package com.domingueti.tradebot.modules.Position.dtos;

import com.domingueti.tradebot.modules.Position.models.OpenPositionSm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class OpenPositionSmDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long openPositionTypeId;

	private @Getter @Setter Long pairSymbolTypeId;

	private @Getter @Setter Integer leverage;

	private @Getter @Setter BigDecimal size;

	private @Getter @Setter BigDecimal entryPrice;

	private @Getter @Setter BigDecimal stopLoss;

	private @Getter @Setter BigDecimal takeProfit;

	private @Getter @Setter BigDecimal liquidityPrice;

	private @Getter @Setter BigDecimal margin;

	private @Getter @Setter Double roe;

	private @Getter @Setter LocalDate referenceDate;

	public OpenPositionSmDTO(OpenPositionSm model) {
		this.openPositionTypeId = model.getOpenPositionTypeId();
		this.pairSymbolTypeId = model.getPairSymbolTypeId();
		this.leverage = model.getLeverage();
		this.size = model.getSize();
		this.entryPrice = model.getEntryPrice();
		this.stopLoss = model.getStopLoss();
		this.takeProfit = model.getTakeProfit();
		this.liquidityPrice = model.getLiquidityPrice();
		this.margin = model.getMargin();
		this.roe = model.getRoe();
		this.referenceDate = model.getReferenceDate();
	}

}
