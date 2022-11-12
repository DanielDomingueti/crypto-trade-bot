package com.domingueti.tradebot.modules.User.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Service
public class GetUserByIdService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public UserDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		
		User user = userRepository.findByIdAndDeletedAtIsNull(id);
		
		if (user == null) {
			throw new NotFoundException("User not found with given ID: " + id + " while fetching.");
		}
		
		return new UserDTO(user);
	}
	
}
