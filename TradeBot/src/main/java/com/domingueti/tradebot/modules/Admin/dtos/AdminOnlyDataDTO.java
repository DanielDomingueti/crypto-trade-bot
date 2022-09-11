package com.domingueti.tradebot.modules.Admin.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

public interface AdminOnlyDataDTO extends Serializable {
	
	Long getId();

	String getName();

	String getEmail();

	Boolean getActive();

	Timestamp getCreatedAt();

	Timestamp getUpdatedAt();

	Timestamp getDeletedAt();

}
