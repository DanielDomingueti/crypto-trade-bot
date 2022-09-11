package com.domingueti.tradebot.security.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.domingueti.tradebot.modules.Admin.dtos.AdminAuthenticationDTO;
import com.domingueti.tradebot.modules.Admin.dtos.AdminOnlyDataDTO;
import com.domingueti.tradebot.modules.Admin.repositories.AdminRepository;
import com.domingueti.tradebot.security.dtos.AdminLoginResponseDTO;
import com.domingueti.tradebot.security.jwt.JWTHandler;
import com.domingueti.tradebot.security.jwt.SecurityConstants;
import com.domingueti.tradebot.utils.statics.ApplicationContextUtils;
import com.domingueti.tradebot.utils.statics.TransformObjectToString;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private ApplicationContext appCtx;

	public AdminAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
		appCtx = ApplicationContextUtils.getAppContext();
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			AdminAuthenticationDTO adminDto = mapper.readValue(req.getInputStream(), AdminAuthenticationDTO.class);
		
			return authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(adminDto.getEmail(), adminDto.getPassword()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		ApplicationContext appCtx = ApplicationContextUtils.getAppContext();
		JWTHandler jwtHandler = (JWTHandler) appCtx.getBean("jwtHandler");
		SecurityConstants securityConstants = (SecurityConstants) appCtx.getBean("securityConstants");
		AdminRepository adminRepository = (AdminRepository) appCtx.getBean("adminRepository");

		String credential = ((User) auth.getPrincipal()).getUsername();
		long expirationTime = securityConstants.getAdminExpirationTime();

		List<String> authList = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> authList.add(authority.getAuthority()));
		String[] authorities = authList.toArray(String[]::new);

		String token = jwtHandler.createToken(credential, authorities, expirationTime);

		AdminOnlyDataDTO admin = adminRepository.findByEmailAndDeletedAtIsNull(credential);

		AdminLoginResponseDTO loginResponse = new AdminLoginResponseDTO(admin.getId(), admin.getName(), token,
				securityConstants.getTokenType(), expirationTime, authorities);

		String responseBody = TransformObjectToString.execute(loginResponse);

		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(responseBody);
	}

}