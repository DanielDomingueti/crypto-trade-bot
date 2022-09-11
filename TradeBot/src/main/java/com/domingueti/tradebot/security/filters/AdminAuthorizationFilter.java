package com.domingueti.tradebot.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.domingueti.tradebot.security.exceptions.TokenExceptionHandler;
import com.domingueti.tradebot.security.jwt.JWTAuthentication;
import com.domingueti.tradebot.security.jwt.SecurityConstants;
import com.domingueti.tradebot.utils.statics.ApplicationContextUtils;

public class AdminAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTAuthentication jwtAuth;
	private ApplicationContext appCtx;
	private SecurityConstants securityConstants;
	private TokenExceptionHandler tokenExceptionHandler;
	
	public AdminAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
		jwtAuth = new JWTAuthentication();
		appCtx = ApplicationContextUtils.getAppContext();
		securityConstants = (SecurityConstants) appCtx.getBean("securityConstants");
		tokenExceptionHandler = (TokenExceptionHandler) appCtx.getBean("tokenExceptionHandler");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(securityConstants.getHeaderString());

		System.out.println(req.getMethod() + ": " + req.getRequestURI());

		if (header == null || !header.startsWith(securityConstants.getTokenType())) {
			chain.doFilter(req, res);
			return;
		}

		String token = header.replace(securityConstants.getTokenType(), "");

		if (!tokenExceptionHandler.verify(token, req, res)) {
			return;
		}

		UsernamePasswordAuthenticationToken authentication = jwtAuth.getAdminAuthentication(req, false);

		if (authentication == null) {
			chain.doFilter(req, res);
			return;
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

}
