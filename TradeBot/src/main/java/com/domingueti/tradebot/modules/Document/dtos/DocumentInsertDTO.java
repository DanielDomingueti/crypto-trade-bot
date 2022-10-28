package com.domingueti.tradebot.modules.Document.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DocumentInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "User ID is mandatory")
	private @Getter @Setter Long userId;
	
	@NotNull(message = "Document type ID is mandatory")
	private @Getter @Setter Long documentTypeId;
	
	@NotNull(message = "Document number is mandatory")
	private @Getter @Setter String number;
	
	@NotNull(message = "Main option is mandatory")
	private @Getter @Setter Boolean main;
	
	@NotNull(message = "Issuing entity is mandatory")
	private @Getter @Setter String issuingEntity;
	
	@NotNull(message = "Issuing date is mandatory")
	private @Getter @Setter LocalDate issueDate;

	@NotNull(message = "Due date is mandatory")
	private @Getter @Setter LocalDate dueDate;
	
	private @Getter @Setter String link;
	
}
