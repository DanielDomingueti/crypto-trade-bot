package com.domingueti.tradebot.security.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TokenException {
	
	public static final String STATUS_EXPIRED_MESSAGE = "Token expired. Access denied";
	
	public static final String STATUS_INVALID_MESSAGE = "Token expired. Access denied";
	
	private @Getter @Setter Date timestamp;

	private @Getter @Setter String error;

	private @Getter @Setter Integer status;

	private @Getter @Setter String message;

	private @Getter @Setter String path;
	
}