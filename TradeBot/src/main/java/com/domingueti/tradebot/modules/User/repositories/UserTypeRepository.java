package com.domingueti.tradebot.modules.User.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.User.models.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long>{

	UserType findByIdAndDeletedAtIsNull(Long id);

}
