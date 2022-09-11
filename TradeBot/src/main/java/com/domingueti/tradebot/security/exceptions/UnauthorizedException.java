package com.domingueti.tradebot.security.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UnauthorizedException {
	
	public static final String STATUS_ERROR_MESSAGE = "Login não autorizado com as credenciais informadas";

	public static final String STATUS_ERROR_ADMIN_DEACTIVATED_MESSAGE = "Login não autorizado: Administrador desativado";

	public static final String STATUS_ERROR_USER_DEACTIVATED_MESSAGE = "Login não autorizado: Usuário desativado";

	private @Getter @Setter Date timestamp;

	private @Getter @Setter String error;

	private @Getter @Setter Integer status;

	private @Getter @Setter String message;

	private @Getter @Setter String path;
}
