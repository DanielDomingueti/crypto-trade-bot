package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypePatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String type;
	
	private @Getter @Setter String description;
}
