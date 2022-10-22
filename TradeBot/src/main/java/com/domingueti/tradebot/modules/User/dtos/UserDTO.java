package com.domingueti.tradebot.modules.User.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;
	
	private @Getter @Setter String name;

	private @Getter @Setter String email;

	private @Getter @Setter Boolean isAdmin;
	
}
