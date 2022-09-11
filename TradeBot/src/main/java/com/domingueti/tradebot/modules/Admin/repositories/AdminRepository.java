package com.domingueti.tradebot.modules.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Admin.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String email);

}
