package com.domingueti.tradebot.modules.Admin.dtos;

import java.io.Serializable;

public interface AdminRouteDTO extends Serializable {

	Long getId();

	String getName();

	String getRoute();
	
	String getMethod();
	
	String getDescription();

}
