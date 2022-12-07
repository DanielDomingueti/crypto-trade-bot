package com.domingueti.tradebot.modules.User.dtos;

import com.domingueti.tradebot.modules.User.models.UserWallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class UserWalletDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long userId;

	private @Getter @Setter String address;

	public UserWalletDTO(UserWallet model) {
		this.userId = model.getUserId();
		this.address = model.getAddress();
	}
	
}
