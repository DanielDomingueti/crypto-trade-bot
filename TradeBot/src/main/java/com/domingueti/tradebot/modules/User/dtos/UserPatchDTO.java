package com.domingueti.tradebot.modules.User.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserPatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String name;
	
	private @Getter @Setter String email;
	
}
