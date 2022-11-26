package com.domingueti.tradebot.modules.UserBankTransaction.repositories;

import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBankTransactionTypeRepository extends JpaRepository<UserBankTransactionType, Long> {

	UserBankTransactionType findByIdAndDeletedAtIsNull(Long id);
	
	List<UserBankTransactionType> findAllByDeletedAtIsNull();
	
}
