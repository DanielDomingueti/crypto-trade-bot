package com.domingueti.tradebot.security.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserLoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	
}
