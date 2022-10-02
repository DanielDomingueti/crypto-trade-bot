package com.domingueti.tradebot.modules.Admin.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class AdminAuthenticationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String email;

	private @Getter @Setter String password;

}
