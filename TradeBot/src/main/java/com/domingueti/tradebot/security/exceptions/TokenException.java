package com.domingueti.tradebot.security.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TokenException {

	public static final String STATUS_EXPIRED_MESSAGE = "Acesso negado, token expirado";
	
	public static final String STATUS_INVALID_MESSAGE = "Acesso negado, token inválido";
	
	private @Getter @Setter Date timestamp;

	private @Getter @Setter String error;

	private @Getter @Setter Integer status;

	private @Getter @Setter String message;

	private @Getter @Setter String path;
	
}
