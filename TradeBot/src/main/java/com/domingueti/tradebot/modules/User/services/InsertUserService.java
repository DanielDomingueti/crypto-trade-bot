package com.domingueti.tradebot.modules.User.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.modules.User.validators.InsertUserValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertUserService {

	private UserRepository userRepository;
	
	private InsertUserValidator validator;
	
	@Transactional
	public UserDTO execute(UserInsertDTO dto) {
		validator.execute(dto);
		
		User user = new User();
		
		copyDtoToModel(dto, user);
		user = userRepository.save(user);
		
		return new UserDTO(user);
	}

	private void copyDtoToModel(UserInsertDTO dto, User model) {
		model.setUserTypeId(dto.getUserTypeId());
		model.setName(dto.getName());
		model.setEmail(dto.getEmail());
		model.setPassword(dto.getPassword());
		model.setIsAdmin(dto.getIsAdmin());
	}
	
}