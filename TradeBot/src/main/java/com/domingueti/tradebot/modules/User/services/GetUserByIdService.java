package com.domingueti.tradebot.modules.User.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.modules.User.validators.GetUserByIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GetUserByIdService {

	private UserRepository userRepository;
	
	private GetUserByIdValidator validator;
	
	@Transactional(readOnly = true)
	public UserDTO execute(Long id) {
		
		validator.execute(id);
		
		User user = userRepository.findByIdAndDeletedAtIsNull(id);
		
		return new UserDTO(user);
	}
	
}
