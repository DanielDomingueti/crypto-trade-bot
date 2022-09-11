package com.domingueti.tradebot.modules.User.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.domingueti.tradebot.modules.User.dtos.UserOnlyDataDTO;
import com.domingueti.tradebot.modules.User.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	UserOnlyDataDTO findOneByEmailOrDocumentAndDeletedAtIsNull(String emailOrDocument, String method,
			String requestURI);
	
	@Query(value = ""
			+ "SELECT userObj.* FROM tb_user userObj "
			+ "INNER JOIN tb_document docObj "
			+ "ON userObj.id = docObj.user_id "
			+ "WHERE (userObj.email = :emailOrDocument "
			+ "OR (docObj.number = :emailOrDocument AND docObj.main = TRUE)) "
			+ "AND userObj.deleted_at IS NULL "
			+ "LIMIT 1",
			nativeQuery = true)
	User findByEmailOrDocument(String emailOrDocument);
	
    UserOnlyDataDTO findTop1ByEmailOrDocuments_NumberAndDocuments_MainIsTrue(String email, String document);

}
