package com.domingueti.tradebot.modules.User.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class UserAuthenticationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String credential;
	
	private @Getter @Setter String password;

}
