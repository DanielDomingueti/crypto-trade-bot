package com.domingueti.tradebot.modules.User.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.User.dtos.UserDTO;
import com.domingueti.tradebot.modules.User.dtos.UserInsertDTO;

@Service
public class InsertUserService {

	@Transactional
	public UserDTO execute(UserInsertDTO dto) {
//		validator.execute(userId); check with authenticated userId;
		
		return null;
	}
	
}
