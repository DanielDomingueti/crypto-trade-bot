package com.domingueti.tradebot.modules.BalanceFuture.controllers.simulation;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation.BsFutureBalanceSmDTO;
import com.domingueti.tradebot.modules.BalanceFuture.services.simulation.GetBsFutureBalanceSmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/bsFutureBalance/sm")
public class BsFutureBalanceSmController {

    private GetBsFutureBalanceSmService getBusinessFutureBalanceSimulationService;

    @GetMapping
    public ResponseEntity<BsFutureBalanceSmDTO> getLatestBusinessFutureBalance() {
        BsFutureBalanceSmDTO dto = getBusinessFutureBalanceSimulationService.execute();

        return ResponseEntity.ok().body(dto);
    }

}
