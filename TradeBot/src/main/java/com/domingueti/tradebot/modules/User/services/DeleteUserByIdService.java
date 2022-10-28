package com.domingueti.tradebot.modules.User.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Service
public class DeleteUserByIdService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void execute(Long id) {
//		validator.execute(id); 
		userRepository.deleteById(id);
	}
	
}
