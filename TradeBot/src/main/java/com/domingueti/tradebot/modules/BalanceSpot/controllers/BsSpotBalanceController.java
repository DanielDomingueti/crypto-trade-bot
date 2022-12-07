package com.domingueti.tradebot.modules.BalanceSpot.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/businessSpotBalance")
public class BsSpotBalanceController {

    private GetBsSpotBalanceByCryptocurrencyIdService getBsSpotBalanceByCryptocurrencyIdService;
    private GetBsSpotBalanceService getBsSpotBalanceService;

    @GetMapping(path = "/cryptocurrency/{cryptoId}")
    public ResponseEntity<BsSpotBalanceDTO> getBusinessSpotBalanceByCryptocurrencyId(@PathVariable Long cryptoId) {

        return null;
    }

    @GetMapping
    public ResponseEntity<BsSpotBalanceDTO> getBusinessSpotBalance() {

        return null;
    }

}
