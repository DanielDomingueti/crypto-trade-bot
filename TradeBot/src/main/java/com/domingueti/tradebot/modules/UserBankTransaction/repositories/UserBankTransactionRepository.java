package com.domingueti.tradebot.modules.UserBankTransaction.repositories;

import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBankTransactionRepository extends JpaRepository<UserBankTransaction, Long> {

	UserBankTransaction findByIdAndDeletedAtIsNull(Long id);

	UserBankTransaction findByUserIdAndDeletedAtIsNull(Long userId);
	
	List<UserBankTransaction> findAllByDeletedAtIsNull();
	
	Boolean existsByUserIdAndDeletedAtIsNull(Long userId);
	
}
