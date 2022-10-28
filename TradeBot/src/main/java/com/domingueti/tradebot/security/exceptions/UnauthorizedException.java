package com.domingueti.tradebot.security.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UnauthorizedException {
	
	public static final String STATUS_ERROR_MESSAGE = "Unauthorized login with given credentials.";
	
	public static final String STATUS_FORBIDDEN_USER_ROUTE = "The given user does not have access to this route.";
	
	public static final String STATUS_ERROR_USER_DEACTIVATED_MESSAGE = "Unauthorized login: unabled user.";
	
	private @Getter @Setter Date timestamp;

	private @Getter @Setter String error;

	private @Getter @Setter Integer status;

	private @Getter @Setter String message;

	private @Getter @Setter String path;

}