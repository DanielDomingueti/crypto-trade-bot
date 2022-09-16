package com.domingueti.tradebot.modules.User.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.User.dtos.UserRouteDTO;
import com.domingueti.tradebot.modules.User.models.UserRoute;

public interface UserRouteRepository extends JpaRepository<UserRoute, Long>{

	List<UserRouteDTO> findAllByDeletedAtIsNull();

}
