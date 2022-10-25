package com.domingueti.tradebot.modules.Cryptocurrency.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CryptocurrencyPatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String symbol;
	
	private @Getter @Setter String name;

}
