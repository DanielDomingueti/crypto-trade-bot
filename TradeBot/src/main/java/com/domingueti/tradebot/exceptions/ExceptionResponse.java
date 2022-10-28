package com.domingueti.tradebot.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter Date timestamp;
	
	private @Getter @Setter String error;
	
	private @Getter @Setter Integer status;
	
	private @Getter @Setter String message;
	
	private @Getter @Setter String path;
	
}