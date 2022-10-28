package com.domingueti.tradebot.modules.CashBalance.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CashBalanceTypeInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Document type is mandatory")
	private @Getter @Setter String type;
	
	@NotNull(message = "Document type description is mandatory")
	private @Getter @Setter String description;
}
