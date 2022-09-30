package com.domingueti.tradebot.modules.User.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.domingueti.tradebot.modules.User.dtos.UserOnlyDataDTO;
import com.domingueti.tradebot.modules.User.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

    @Query(value = ""
    		+ "SELECT DISTINCT userObj.id, userObj.name "
    		+ "FROM tb_user userObj "
    		+ "INNER JOIN tb_pivot_user_group_user userGroupUser "
    		+ "ON (userObj.id = userGroupUser.user_id) "
    		+ "INNER JOIN tb_user_group userGroup "
    		+ "ON (userGroup.id = userGroupUser.user_group_id) "
    		+ "INNER JOIN tb_pivot_user_group_user_route userGroupUserRoute "
    		+ "ON (userGroup.id = userGroupUserRoute.user_group_id) "
    		+ "INNER JOIN tb_user_route userRoute "
    		+ "ON (userRoute.id = userGroupUserRoute.user_route_id) "
    		+ "WHERE (userObj.email = :email "
    		+ "AND userRoute.method = :method AND userRoute.route = :route "
    		+ "AND userObj.deleted_at IS NULL ",
    		nativeQuery = true)
	UserOnlyDataDTO findOneByEmailAndDeletedAtIsNull(String email, String method, String route);

	UserOnlyDataDTO findTop1ByEmail(String email);
	
}
