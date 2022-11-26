package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;

import com.domingueti.tradebot.modules.Document.models.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long userId;
	
	private @Getter @Setter Long documentTypeId;
	
	private @Getter @Setter String number;
	
	private @Getter @Setter Boolean main;
		
	public DocumentDTO(Document document) {
		userId = document.getUserId();
		number = document.getNumber();
		main = document.getMain();
		documentTypeId = document.getDocumentTypeId();
	}
	
}
