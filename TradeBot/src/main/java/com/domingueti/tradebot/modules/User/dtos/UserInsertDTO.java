package com.domingueti.tradebot.modules.User.dtos;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;

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
	
	@Valid
	@Size(min = 1, message = "At least one document is required for the user")
	private @Getter @Setter List<DocumentInsertDTO> documentInserts = new ArrayList<>();
	
}
