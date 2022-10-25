package com.domingueti.tradebot.modules.User.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserPatchDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;

@Service
public class PatchUserByIdService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public UserDTO execute(Long id, UserPatchDTO userDTO) {
//		user = validator.execute(id); insert findById inside of validator. 
		User user = userRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(userDTO, user);
		
		user = userRepository.save(user);
		
		return new UserDTO(user);
	}

	private void copyDtoToModel(UserPatchDTO dto, User model) {
		model.setName(dto.getName() != null ? dto.getName() : model.getName());
		model.setEmail(dto.getEmail() != null ? dto.getEmail() : model.getEmail());
	}
	
}
