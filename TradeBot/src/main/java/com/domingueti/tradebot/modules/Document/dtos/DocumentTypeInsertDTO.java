package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Document type is mandatory")
	private @Getter @Setter String type;
	
	@NotNull(message = "Document description is mandatory")
	private @Getter @Setter String description;
	
	public DocumentTypeInsertDTO(DocumentTypeDTO documentTypeDTO) {
		type = documentTypeDTO.getType();
		description = documentTypeDTO.getDescription();
	}

}
