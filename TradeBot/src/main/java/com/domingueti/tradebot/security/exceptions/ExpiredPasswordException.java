package com.domingueti.tradebot.security.exceptions;

import org.springframework.security.core.AuthenticationException;

public class ExpiredPasswordException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public ExpiredPasswordException(String msg) {
        super(msg);
    }
}