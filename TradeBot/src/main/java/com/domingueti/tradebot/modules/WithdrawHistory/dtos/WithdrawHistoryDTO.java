package com.domingueti.tradebot.modules.WithdrawHistory.dtos;

import com.domingueti.tradebot.modules.WithdrawHistory.models.WithdrawHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class WithdrawHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long cryptocurrencyId;

	private @Getter @Setter Long investmentId;

	private @Getter @Setter BigDecimal value;

	private @Getter @Setter LocalDate referenceDate;

	public WithdrawHistoryDTO(WithdrawHistory model) {
		this.cryptocurrencyId = model.getCryptocurrencyId();
		this.investmentId = model.getInvestmentId();
		this.value = model.getValue();
		this.referenceDate = model.getReferenceDate();
	}
}
