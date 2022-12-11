package com.domingueti.tradebot.modules.BalanceFuture.services.simulation;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation.BsFutureBalanceSmDTO;
import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalanceSm;
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
        BsFutureBalanceSm bsFutureBalanceSm = bsFutureBalanceSimulationRepository.findTop1ByOrderByReferenceDateDesc();

        return new BsFutureBalanceSmDTO(bsFutureBalanceSm);
    }

}
