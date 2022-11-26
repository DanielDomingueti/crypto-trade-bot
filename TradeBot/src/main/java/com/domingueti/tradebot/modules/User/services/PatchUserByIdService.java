package com.domingueti.tradebot.modules.User.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.modules.User.validators.PatchUserByIdValidator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatchUserByIdService {

	private UserRepository userRepository;
	
	private PatchUserByIdValidator validator;
	
	@Transactional
	public UserDTO execute(Long id, UserPatchDTO userDTO) {
		
		validator.execute(id, userDTO);
		
		User user = userRepository.findByIdAndDeletedAtIsNull(id);
		if (user == null) {
			throw new NotFoundException("User not found with given ID: " + id + " while patching.");
		}
		
		copyDtoToModel(userDTO, user);
		
		user = userRepository.save(user);
		
		return new UserDTO(user);
	}

	private void copyDtoToModel(UserPatchDTO dto, User model) {
		model.setName(dto.getName() != null ? dto.getName() : model.getName());
		model.setEmail(dto.getEmail() != null ? dto.getEmail() : model.getEmail());
	}
	
}
