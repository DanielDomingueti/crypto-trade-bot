package com.domingueti.tradebot.modules.CashBalance.services.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeDTO;
import com.domingueti.tradebot.modules.CashBalance.dtos.CashBalanceTypeInsertDTO;
import com.domingueti.tradebot.modules.CashBalance.models.CashBalanceType;
import com.domingueti.tradebot.modules.CashBalance.repositories.CashBalanceTypeRepository;

@Service
public class InsertCashBalanceTypeService {

	@Autowired
	private CashBalanceTypeRepository cashBalanceTypeRepository;
	
	@Transactional
	public CashBalanceTypeDTO execute(CashBalanceTypeInsertDTO cashBalanceTypeInsertDTO) {
//		validator(cashBalanceInsertDTO);
		
		CashBalanceType cashBalanceType = new CashBalanceType();
		copyDtoToModel(cashBalanceTypeInsertDTO, cashBalanceType);
		
		cashBalanceType = cashBalanceTypeRepository.save(cashBalanceType);
		
		return new CashBalanceTypeDTO(cashBalanceType);
	}

	private void copyDtoToModel(CashBalanceTypeInsertDTO dto, CashBalanceType model) {
		model.setType(dto.getType());
		model.setDescription(dto.getDescription());
	}
	
}
