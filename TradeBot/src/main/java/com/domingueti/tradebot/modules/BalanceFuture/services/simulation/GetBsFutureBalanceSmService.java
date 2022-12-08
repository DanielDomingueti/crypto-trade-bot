package com.domingueti.tradebot.modules.BalanceFuture.services.simulation;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation.BsFutureBalanceSmDTO;
import com.domingueti.tradebot.modules.BalanceFuture.repositories.simulation.BsFutureBalanceSmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetBsFutureBalanceSmService {

    private BsFutureBalanceSmRepository bsFutureBalanceSimulationRepository;

    @Transactional(readOnly = true)
    public BsFutureBalanceSmDTO execute() {
        BsFutureBalanceSmDTO dto = bsFutureBalanceSimulationRepository.findTop1OrderByReferenceDateDesc();

        return dto;
    }

}
