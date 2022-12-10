package com.domingueti.tradebot.modules.Investment.validators;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;
import com.domingueti.tradebot.modules.Investment.dtos.InvestmentInsertCryptoDTO;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.User.repositories.UserRepository;
import com.domingueti.tradebot.security.dtos.UserPrincipalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InsertInvestmentCryptoValidator {

	private Map<String, String> fieldErrors;	
	private Boolean validInsert;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;
	
	public void execute(InvestmentInsertCryptoDTO dto) {

		UserPrincipalDTO authUserDTO = (UserPrincipalDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User authUser = userRepository.findByIdAndDeletedAtIsNull(authUserDTO.getId());
		
		if (!dto.getUserId().equals(authUser.getId()) && authUser.getIsAdmin().equals(Boolean.FALSE)) {
			fieldErrors.put("investment.user.id", "The user can only insert investments for himself.");
			validInsert = false;
		}
		
		if (!cryptocurrencyRepository.existsById(dto.getResultCryptocurrencyId())) {
			fieldErrors.put("investment.cryptocurrency.id", "The given cryptocurrency ID does not exist.");
			validInsert = false;
		}

		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}
	
}
