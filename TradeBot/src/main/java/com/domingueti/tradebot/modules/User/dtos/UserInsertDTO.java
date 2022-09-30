package com.domingueti.tradebot.modules.User.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UserInsertDTO {

	@NotEmpty(message = "Name is required")
	private @Getter @Setter String name;

	@Email
	@NotEmpty(message = "Email is required")
	private @Getter @Setter String email;

	@NotEmpty(message = "Password is required")
	private @Getter @Setter String password;
	
}
