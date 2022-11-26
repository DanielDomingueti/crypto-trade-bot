package com.domingueti.tradebot.modules.UserBankTransaction.services;

import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionDTO;
import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransaction;
import com.domingueti.tradebot.modules.UserBankTransaction.repositories.UserBankTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetUserBankTransactionsService {

private UserBankTransactionRepository userBankTransactionRepository;
	
	@Transactional(readOnly = true)
	public List<UserBankTransactionDTO> execute() {
		
		List<UserBankTransaction> userBankTransaction = userBankTransactionRepository.findAllByDeletedAtIsNull();
		
		return userBankTransaction.stream().map(UserBankTransactionDTO::new).collect(Collectors.toList());
	}
	
}
