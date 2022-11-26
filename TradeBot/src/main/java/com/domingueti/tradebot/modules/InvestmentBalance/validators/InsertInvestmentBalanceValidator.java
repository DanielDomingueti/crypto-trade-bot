package com.domingueti.tradebot.modules.InvestmentBalance.validators;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domingueti.tradebot.exceptions.FieldMessage;
import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Investment.repositories.InvestmentRepository;
import com.domingueti.tradebot.modules.InvestmentBalance.dtos.InvestmentBalanceInsertDTO;

@Component
public class InsertInvestmentBalanceValidator {

	private Map<String, String> fieldErrors;
	private Boolean validInsert;

	@Autowired
	private InvestmentRepository investmentRepository;

	public void execute(InvestmentBalanceInsertDTO dto) {
		
		if (!investmentRepository.existsByIdAndDeletedAtIsNull(dto.getInvestmentId())) {
			fieldErrors.put("investment.existence", "Investment with ID: " + dto.getInvestmentId() + " does not exist.");
			validInsert = false;
		}

		if (!validInsert) {
			InvalidRequestException exception = new InvalidRequestException("Error while validating given data");

			fieldErrors.forEach((field, message) -> exception.getFields().add(new FieldMessage(field, message)));

			throw exception;
		}
	}

}
