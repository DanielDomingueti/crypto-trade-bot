package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;

import com.domingueti.tradebot.modules.Document.models.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter Long id;
	
	private @Getter @Setter String type;
	
	private @Getter @Setter String description;
	
	public DocumentTypeDTO(DocumentType documentType) {
		id = documentType.getId();
		type = documentType.getType();
		description = documentType.getDescription();
	}

}
