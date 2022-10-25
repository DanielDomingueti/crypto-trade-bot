package com.domingueti.tradebot.modules.User.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetUsersService {
	
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return userRepository.findAll().stream()
				.map(UserDTO::new).toList();
	}

}
