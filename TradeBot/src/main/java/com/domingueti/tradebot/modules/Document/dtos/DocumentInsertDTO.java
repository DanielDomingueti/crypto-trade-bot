package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long userId;
	
	private @Getter @Setter Long documentTypeId;
	
	private @Getter @Setter String number;
	
	private @Getter @Setter String issuingEntity;
	
	private @Getter @Setter LocalDate issueDate;

	private @Getter @Setter LocalDate dueDate;
	
	private @Getter @Setter String link;
	
	private @Getter @Setter Boolean main;
}
