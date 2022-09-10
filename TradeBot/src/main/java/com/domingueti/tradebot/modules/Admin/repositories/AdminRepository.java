package com.domingueti.tradebot.modules.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Admin.dtos.AdminRouteDTO;
import com.domingueti.tradebot.modules.Admin.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	AdminRouteDTO findOneByEmailAndDeletedAtIsNull(String email, String requestURI, String method);

}
