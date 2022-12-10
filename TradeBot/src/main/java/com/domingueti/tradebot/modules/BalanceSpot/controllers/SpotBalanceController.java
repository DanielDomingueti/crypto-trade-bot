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

    @GetMapping(path = "/cryptocurrency/{cryptoId}/user/{userId}")
    public ResponseEntity<SpotBalanceDTO> getLatestSpotBalanceByCryptocurrencyIdAndUserId(@PathVariable Long cryptoId, @PathVariable Long userId) {

        return null;
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<SpotBalanceDTO> getTotalLatestSpotBalanceByUserId(@PathVariable Long userId) {

        return null;
    }

}
