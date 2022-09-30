package com.domingueti.tradebot.modules.Admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Admin.dtos.AdminRouteOnlyDataDTO;
import com.domingueti.tradebot.modules.Admin.models.AdminRoute;

public interface AdminRouteRepository extends JpaRepository<AdminRoute, Long> {

	List<AdminRouteOnlyDataDTO> findByDeletedAtIsNull();
	
}
