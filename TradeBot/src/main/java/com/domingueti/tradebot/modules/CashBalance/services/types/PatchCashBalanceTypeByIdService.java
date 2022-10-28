package com.domingueti.tradebot.modules.CashBalance.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypePatchDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class PatchCashBalanceTypeByIdService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional
	public CashBalanceTypeDTO execute(Long id, CashBalanceTypePatchDTO cashBalanceTypeDTO) {
//		cashBalance = validator.execute(id); insert findById inside of validator. 
		CashBalanceType cashBalanceType = cashBalanceTypeRepository.findByIdAndDeletedAtIsNull(id);
		
		copyDtoToModel(cashBalanceTypeDTO, cashBalanceType);
		
		cashBalanceType = cashBalanceTypeRepository.save(cashBalanceType);
		
		return new CashBalanceTypeDTO(cashBalanceType);
	}

	private void copyDtoToModel(CashBalanceTypePatchDTO dto, CashBalanceType model) {
		model.setType(dto.getType());
		model.setDescription(dto.getDescription());
	}
	
}
