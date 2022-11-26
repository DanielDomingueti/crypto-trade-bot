package com.domingueti.tradebot.modules.UserBankTransaction.services.types;

import com.domingueti.tradebot.modules.UserBankTransaction.dtos.UserBankTransactionTypeDTO;
import com.domingueti.tradebot.modules.UserBankTransaction.models.UserBankTransactionType;
import com.domingueti.tradebot.modules.UserBankTransaction.repositories.UserBankTransactionTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetUserBankTransactionTypesService {

	private UserBankTransactionTypeRepository userBankTransactionTypeRepository;
	
	@Transactional(readOnly = true)
	public List<UserBankTransactionTypeDTO> execute() {
		
		List<UserBankTransactionType> userBankTransactionTypes = userBankTransactionTypeRepository.findAllByDeletedAtIsNull();
		
		return userBankTransactionTypes.stream().map(UserBankTransactionTypeDTO::new).collect(Collectors.toList());
	}
	
}
