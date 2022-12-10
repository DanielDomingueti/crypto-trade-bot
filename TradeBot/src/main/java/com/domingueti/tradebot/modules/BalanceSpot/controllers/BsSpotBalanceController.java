package com.domingueti.tradebot.modules.BalanceSpot.controllers;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.BsSpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.services.GetBsSpotBalanceByCryptocurrencyIdService;
import com.domingueti.tradebot.modules.BalanceSpot.services.GetBsSpotBalanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/bsSpotBalance")
public class BsSpotBalanceController {

    private GetBsSpotBalanceByCryptocurrencyIdService getBsSpotBalanceByCryptocurrencyIdService;
    private GetBsSpotBalanceService getBsSpotBalanceService;

    @GetMapping(path = "/cryptocurrency/{cryptoId}")
    public ResponseEntity<BsSpotBalanceDTO> getLatestBusinessSpotBalanceByCryptocurrencyId(@PathVariable Long cryptoId) {
        BsSpotBalanceDTO dto = getBsSpotBalanceByCryptocurrencyIdService.execute(cryptoId);

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<BsSpotBalanceDTO> getTotalLatestBusinessSpotBalance() {
        BsSpotBalanceDTO dto = getBsSpotBalanceService.execute();

        return ResponseEntity.ok().body(dto);
    }

}
