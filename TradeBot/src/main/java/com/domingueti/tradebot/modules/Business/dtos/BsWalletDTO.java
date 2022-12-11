package com.domingueti.tradebot.modules.Business.dtos;

import com.domingueti.tradebot.modules.Business.models.BsWallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class BsWalletDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;

	private @Getter @Setter String address;

	public BsWalletDTO(BsWallet model) {
		this.id = model.getId() == null ? null : model.getId();
		this.address = model.getAddress() == null ? null : model.getAddress();
	}

}
