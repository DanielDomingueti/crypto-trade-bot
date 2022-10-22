package com.domingueti.tradebot.modules.User.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UserInsertDTO {

	@NotNull(message = "Name is mandatory")
	private @Getter @Setter String name;

	@Email
	@NotEmpty(message = "Email is mandatory")
	private @Getter @Setter String email;

	@NotEmpty(message = "Password is mandatory")
	private @Getter @Setter String password;
	
	@NotNull(message = "Admin option is mandatory")
	private @Getter @Setter Boolean isAdmin;
	
	
}
