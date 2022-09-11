package com.domingueti.tradebot.security.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UserLoginResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;
	
	private @Getter @Setter String user;

	private @Getter @Setter boolean adminLogin;
	
	private @Getter @Setter String token;
	
	private @Getter @Setter String tokenType;
	
	private @Getter @Setter Long expirationTime;
	
	private @Getter @Setter String[] authorities;

}
