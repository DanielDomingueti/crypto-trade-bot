package com.domingueti.tradebot.modules.User.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.User.dtos.UserGroupDTO;
import com.domingueti.tradebot.modules.User.models.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long>{

	List<UserGroupDTO> findAllByDeletedAtIsNull();

	Long findIdByDescriptionAndDeletedAtIsNull(String description);

}
