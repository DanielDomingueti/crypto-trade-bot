package com.domingueti.tradebot.modules.Position.dtos;

import com.domingueti.tradebot.modules.Position.models.PairSymbolType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class PairSymbolTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String type;

	private @Getter @Setter String description;

	public PairSymbolTypeDTO(PairSymbolType model) {
		this.type = model.getType();
		this.description = model.getDescription();
	}

}
