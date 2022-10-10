package com.domingueti.tradebot.security.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.domingueti.tradebot.modules.Admin.models.Admin;
import com.domingueti.tradebot.modules.Admin.repositories.AdminRepository;

@Service
public final class AdminDetailsServiceImpl implements UserDetailsService {
	private AdminRepository adminRepository;

	public AdminDetailsServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String credential) throws UsernameNotFoundException {
		Admin applicationAdmin = adminRepository.findByEmail(credential.toLowerCase());
		
		if (applicationAdmin == null) {
			throw new UsernameNotFoundException(credential);
		}
		
		String adminPassword = applicationAdmin.getPassword() == null ? "" : applicationAdmin.getPassword();

		Collection<GrantedAuthority> adminGroups = applicationAdmin.getAdminGroups().stream()
				.map(group -> new SimpleGrantedAuthority(group.getName().toUpperCase())).collect(Collectors.toList());

		return new User(applicationAdmin.getEmail(), adminPassword, true, true,
				true, true, adminGroups);

	}
}