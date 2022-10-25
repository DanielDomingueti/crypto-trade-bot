package com.domingueti.tradebot.modules.Cryptocurrency.dtos;

import java.io.Serializable;

import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CryptocurrencyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String symbol;
	
	private @Getter @Setter String name;
	
	public CryptocurrencyDTO(Cryptocurrency model) {
		this.symbol = model.getSymbol();
		this.name = model.getName();
	}

}
