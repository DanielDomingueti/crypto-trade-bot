package com.domingueti.tradebot.modules.Admin.dtos;

import java.io.Serializable;

public interface AdminOnlyDataDTO extends Serializable {
	
	Long getId();

	String getName();

	String getEmail();

}
