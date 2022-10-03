package com.domingueti.tradebot.security.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.domingueti.tradebot.security.exceptions.TokenExceptionHandler;
import com.domingueti.tradebot.security.jwt.JWTAuthentication;
import com.domingueti.tradebot.security.jwt.JWTHandler;
import com.domingueti.tradebot.security.jwt.SecurityConstants;
import com.domingueti.tradebot.utils.statics.ApplicationContextUtils;

public class UserAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTAuthentication jwtAuth;
	private ApplicationContext appCtx;
	private JWTHandler jwtHandler;
	private SecurityConstants securityConstants;
	private TokenExceptionHandler tokenExceptionHandler;
	
	public UserAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
		jwtAuth = new JWTAuthentication();
		appCtx = ApplicationContextUtils.getAppContext();
		jwtHandler = (JWTHandler) appCtx.getBean("jwtHandler");
		securityConstants = (SecurityConstants) appCtx.getBean("securityConstants");
		tokenExceptionHandler = (TokenExceptionHandler) appCtx.getBean("tokenExceptionHandler");
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String header = req.getHeader(securityConstants.getHeaderString());
		UsernamePasswordAuthenticationToken authentication;

		if (header == null || !header.startsWith(securityConstants.getTokenType())) {
			chain.doFilter(req, res);
			return;
		}

		String token = header.replace(securityConstants.getTokenType(), "");

		if (!tokenExceptionHandler.verify(token, req, res)) {
			return;
		}

		if (isAdminAccess(req)) {
			authentication = jwtAuth.getAdminAuthentication(req, true);
		}
		else {
			authentication = jwtAuth.getUserAuthentication(req);
		}
		
		if (authentication == null) {
			return;
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}
	
	private boolean isAdminAccess(HttpServletRequest request) {
		String token = request.getHeader(securityConstants.getHeaderString())
				.replace(securityConstants.getTokenType(), "");
		
		if (token != null) {
			List<String> authorities = jwtHandler.getAuthoritiesString(token);
			
			if(authorities.contains("ADMIN"))
				return true;
		}
		
		return false;
	}



}
