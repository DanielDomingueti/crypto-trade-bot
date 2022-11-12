package com.domingueti.tradebot.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String fieldName;
	private @Getter @Setter String message;
	
}