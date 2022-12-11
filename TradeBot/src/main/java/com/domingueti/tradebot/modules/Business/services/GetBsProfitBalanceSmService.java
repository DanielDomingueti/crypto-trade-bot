package com.domingueti.tradebot.modules.Business.services;

import com.domingueti.tradebot.modules.Business.dtos.BsProfitBalanceSmDTO;
import com.domingueti.tradebot.modules.Business.models.BsProfitBalanceSm;
import com.domingueti.tradebot.modules.Business.repositories.BsProfitBalanceSmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetBsProfitBalanceSmService {

    private BsProfitBalanceSmRepository bsProfitBalanceSmRepository;

    @Transactional(readOnly = true)
    public BsProfitBalanceSmDTO execute() {
        BsProfitBalanceSm bsProfitBalanceSm = bsProfitBalanceSmRepository.findTop1ByDeletedAtIsNullOrderByReferenceDateDesc();

        return new BsProfitBalanceSmDTO(bsProfitBalanceSm);
    }
}
