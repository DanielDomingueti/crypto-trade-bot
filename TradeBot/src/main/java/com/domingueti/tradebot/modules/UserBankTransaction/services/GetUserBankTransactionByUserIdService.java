package com.domingueti.tradebot.modules.UserBankTransaction.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionDTO;
import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransaction;
import com.domingueti.tradebot.modules.UserBankTransaction.repositories.UserBankTransactionRepository;
import com.domingueti.tradebot.modules.UserBankTransaction.validator.GetUserBankTransactionByUserIdValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GetUserBankTransactionByUserIdService {

	private UserBankTransactionRepository UserBankTransactionRepository;
	
	private GetUserBankTransactionByUserIdValidator validator;
	
	@Transactional(readOnly = true)
	public UserBankTransactionDTO execute(Long userId) {
		validator.execute(userId);

		UserBankTransaction userBankTransaction = UserBankTransactionRepository.findByUserIdAndDeletedAtIsNull(userId);
		
		if (userBankTransaction == null) {
			throw new NotFoundException("Bank transaction not found by given UserID: " + userId + " while fetching.");
		}
		
		return new UserBankTransactionDTO(userBankTransaction);
		
	}
	
}
