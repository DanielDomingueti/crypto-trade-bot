package com.domingueti.tradebot.modules.User.dtos;

import java.io.Serializable;

import com.domingueti.tradebot.modules.User.models.User;

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
	
	public UserDTO(User model) {
		this.id = model.getId();
		this.name = model.getName();
		this.email = model.getEmail();
		this.isAdmin = model.getIsAdmin();
	}
	
}
