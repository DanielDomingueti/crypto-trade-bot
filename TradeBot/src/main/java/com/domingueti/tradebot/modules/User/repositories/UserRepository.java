package com.domingueti.tradebot.modules.User.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.User.dtos.UserOnlyDataDTO;
import com.domingueti.tradebot.modules.User.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	UserOnlyDataDTO findOneByEmailOrDocumentAndDeletedAtIsNull(String emailOrDocument, String method,
			String requestURI);

}
