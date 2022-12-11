package com.domingueti.tradebot.modules.Business.services;

import com.domingueti.tradebot.modules.Business.dtos.BsProfitBalanceDTO;
import com.domingueti.tradebot.modules.Business.models.BsProfitBalance;
import com.domingueti.tradebot.modules.Business.repositories.BsProfitBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetBsProfitBalanceService {

    private BsProfitBalanceRepository bsProfitBalanceRepository;

    @Transactional(readOnly = true)
    public BsProfitBalanceDTO execute() {
        BsProfitBalance bsProfitBalance = bsProfitBalanceRepository.findTop1ByDeletedAtIsNullOrderByReferenceDateDesc();

        return new BsProfitBalanceDTO(bsProfitBalance);
    }
}
