package com.domingueti.tradebot.modules.BalanceSpot.controllers;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.SpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.services.GetSpotBalanceByCryptocurrencyIdService;
import com.domingueti.tradebot.modules.BalanceSpot.services.GetSpotBalanceByUserIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/spotBalance")
public class SpotBalanceController {

    private GetSpotBalanceByCryptocurrencyIdService getSpotBalanceByCryptocurrencyIdService;
    private GetSpotBalanceByUserIdService getSpotBalanceByUserIdService;

    @GetMapping(path = "/cryptocurrency/{cryptoId}")
    public ResponseEntity<SpotBalanceDTO> getSpotBalanceByCryptocurrencyId(@PathVariable Long cryptoId) {

        return null;
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<SpotBalanceDTO> getSpotBalanceByUserId(@PathVariable Long userId) {

        return null;
    }

}
