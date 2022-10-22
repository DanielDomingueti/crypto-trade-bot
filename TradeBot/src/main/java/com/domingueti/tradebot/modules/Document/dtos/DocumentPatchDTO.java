package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentPatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String link;
	
	private @Getter @Setter Boolean main;
}
