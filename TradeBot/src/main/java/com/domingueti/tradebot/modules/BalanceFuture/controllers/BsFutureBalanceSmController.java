package com.domingueti.tradebot.modules.BalanceFuture.controllers;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.BsFutureBalanceSmDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/businessFutureBalance/simulation")
public class BsFutureBalanceSmController {

    private GetBsFutureBalanceSmService getBusinessFutureBalanceSimulationService;

    @GetMapping
    public ResponseEntity<BsFutureBalanceSmDTO> getLatestBusinessFutureBalance() {

        return null;
    }

}
