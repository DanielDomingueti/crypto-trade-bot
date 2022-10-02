package com.domingueti.tradebot.modules.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.domingueti.tradebot.modules.Admin.dtos.AdminOnlyDataDTO;
import com.domingueti.tradebot.modules.Admin.dtos.AdminRouteDTO;
import com.domingueti.tradebot.modules.Admin.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String email);
	
	@Query(value = "" + "SELECT DISTINCT adminRoute.method, adminRoute.route, adm.id, adm.name "
			+ "FROM tb_admin adm INNER JOIN tb_pivot_admin_group_admin pivotAdmGroup "
			+ "ON adm.id = pivotAdmGroup.admin_id " + "INNER JOIN tb_admin_group admGroup "
			+ "ON pivotAdmGroup.admin_group_id = admGroup.id "
			+ "INNER JOIN tb_pivot_admin_group_admin_route pivotAdminRoute "
			+ "ON admGroup.id = pivotAdminRoute.admin_group_id "
			+ "INNER JOIN tb_admin_route adminRoute on pivotAdminRoute.admin_route_id = adminRoute.id "
			+ "WHERE adm.email = :email AND adminRoute.method = :method AND adminRoute.route = :route "
			+ "AND adm.deleted_at IS NULL AND adm.active IS TRUE", nativeQuery = true)
	AdminRouteDTO findOneByEmailAndDeletedAtIsNull(String email, String route, String method);

	AdminOnlyDataDTO findByEmailAndDeletedAtIsNull(String email);

}
