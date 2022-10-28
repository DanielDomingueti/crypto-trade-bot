package com.domingueti.tradebot.modules.Cryptocurrency.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CryptocurrencyInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Cryptocurrency symbol is mandatory")
	private @Getter @Setter String symbol;
	
	@NotNull(message = "Cryptocurrency name is mandatory")
	private @Getter @Setter String name;
	

}
