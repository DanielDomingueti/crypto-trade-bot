package com.domingueti.tradebot.modules.User.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.modules.User.validators.DeleteUserByIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeleteUserByIdService {

	private UserRepository userRepository;
	
	private DeleteUserByIdValidator validator;
	
	@Transactional
	public void execute(Long id) {
		
		User user = userRepository.findByIdAndDeletedAtIsNull(id);	
		
		if (user == null) {
			throw new NotFoundException("User not found with given ID: " + id + " while deleting.");
		}
		
		validator.execute(id); 
		
		userRepository.delete(user);
	}
	
}
