package com.domingueti.tradebot.security.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.domingueti.tradebot.security.dtos.AdminLoginDTO;
import com.domingueti.tradebot.security.dtos.UserLoginDTO;

@Service
public class AuthService {

	public Long getAuthenticatedUserId() {
		UserLoginDTO user = (UserLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return user.getId();
	}

	public Long getAuthenticatedUserAdminId() {
		UserLoginDTO user = (UserLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return user.getAdminId();
	}

	public String getAuthenticatedUserName() {
		UserLoginDTO user = (UserLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return user.getName();
	}

	public boolean isUserAuthenticatedAsAdmin() {
		UserLoginDTO user = (UserLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return user.isAdminLogin();
	}
	
	public Long getAuthenticatedAdminId() {
		AdminLoginDTO admin = (AdminLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return admin.getId();
	}

	public String getAuthenticatedAdminName() {
		AdminLoginDTO admin = (AdminLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return admin.getName();
	}

	public String getAuthenticatedAdminEmail() {
		AdminLoginDTO admin = (AdminLoginDTO) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return admin.getEmail();
	}
	
	public boolean hasAdminAuthority() {
		Collection<? extends GrantedAuthority> authorities =  SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ADMINISTRADOR")) {
				return true;
			}
		}
		
		return false;
	}
	
}
