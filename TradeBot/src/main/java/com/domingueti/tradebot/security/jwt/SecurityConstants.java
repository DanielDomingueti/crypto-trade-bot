package com.domingueti.tradebot.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.modules.Config.dtos.ConfigDTO;
import com.domingueti.tradebot.modules.Config.services.GetConfig;

@Component(value = "securityConstants")
public class SecurityConstants {

	@Autowired
	private GetConfig getConfig;
	
	@Autowired
	private Environment env;
	
	private static final String PROFILE_PROPERTY = "spring.profiles.active";

	@Cacheable("tokenSecret")
	public String getSecret() {
		
		String activeProfile = env.getProperty(PROFILE_PROPERTY) == null ? "" : env.getProperty(PROFILE_PROPERTY);
		ConfigDTO config;
		
		if (activeProfile.equals("prod")) {
			config = getConfig.execute("TOKEN_SECRET_PROD");
		}
		else {
			config = getConfig.execute("TOKEN_SECRET");
		}	

		return config.getValue();
	}
	
	@Cacheable("signInUserUrl")
	public String getSignInUserUrl() {
		ConfigDTO config = getConfig.execute("SIGN_IN_USER_URL");

		return config.getValue();
	}
	
	@Cacheable("signInAdminUrl")
	public String getSignInAdminUrl() {
		ConfigDTO config = getConfig.execute("SIGN_IN_ADMIN_URL");

		return config.getValue();
	}
	
}
