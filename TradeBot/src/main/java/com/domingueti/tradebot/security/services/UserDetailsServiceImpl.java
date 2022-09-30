package com.domingueti.tradebot.security.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Service
public final class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String credential) throws UsernameNotFoundException {
		User applicationUser = userRepository.findByEmail(credential);

		if (applicationUser == null) {
			throw new UsernameNotFoundException(credential);
		}
		
		String userPassword = applicationUser.getPassword() == null ? "" : applicationUser.getPassword();

		Collection<GrantedAuthority> userGroups = applicationUser.getUserGroups().stream()
				.map(group -> new SimpleGrantedAuthority(group.getName().toUpperCase()))
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(credential,
				userPassword, true, true, true, true, userGroups);
	}
}