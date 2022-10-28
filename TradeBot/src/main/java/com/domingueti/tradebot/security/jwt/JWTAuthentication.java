package com.domingueti.tradebot.security.jwt;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.domingueti.tradebot.modules.User.dtos.UserOnlyDataDTO;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.dtos.UserPrincipalDTO;
import com.domingueti.tradebot.utils.statics.ApplicationContextUtils;
import com.domingueti.tradebot.utils.statics.ReplaceRouteNumbers;

public class JWTAuthentication {

	private ApplicationContext appCtx;
	private JWTHandler jwtHandler;
	private SecurityConstants securityConstants;
	
	public JWTAuthentication() {
		appCtx = ApplicationContextUtils.getAppContext();
		jwtHandler = (JWTHandler) appCtx.getBean("jwtHandler");
		securityConstants = (SecurityConstants) appCtx.getBean("securityConstants");
	}
	
	public UsernamePasswordAuthenticationToken getUserAuthentication(HttpServletRequest request) {
		UserRepository userRepository = (UserRepository) appCtx.getBean("userRepository");
		
		String token = request.getHeader(securityConstants.getHeaderString())
				.replace(securityConstants.getTokenType(), "");

		String requestURI = ReplaceRouteNumbers.execute(request.getRequestURI());
		
		//adicionar validacao temporaria das rotas aqui
				
		if (token != null) {

			Collection<SimpleGrantedAuthority> authorities = jwtHandler.getAuthorities(token);
			
			String email = jwtHandler.getSubject(token);
			
			UserOnlyDataDTO findUser = userRepository.findOneByEmailAndDeletedAtIsNull(email, request.getMethod(), requestURI);

			if (findUser != null) {
				UserPrincipalDTO userPrincipal = new UserPrincipalDTO(findUser.getId(), findUser.getName(), email);

				return new UsernamePasswordAuthenticationToken(userPrincipal, email, authorities);
				
			} 
			
		}
		
		return null;

	}
	
}