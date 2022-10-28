package com.domingueti.tradebot.modules.User.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Service
public class GetUsersService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> execute() {
//		validator.execute(userId); check with authenticated userId;
		
		return userRepository.findAll().stream()
				.map(UserDTO::new).toList();
	}

}
