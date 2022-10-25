package com.domingueti.tradebot.modules.User.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetUserByIdService {

	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public UserDTO execute(Long id) {
//		validator.execute(userId); check with authenticated userId;
		User user = userRepository.findByIdAndDeletedAtIsNull(id);
		return new UserDTO(user);
	}
	
}
