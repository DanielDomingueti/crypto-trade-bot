package com.domingueti.tradebot.modules.BalanceFuture.controllers;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.FutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.services.GetFutureBalanceByUserIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/futureBalance")
public class FutureBalanceController {

    private GetFutureBalanceByUserIdService getFutureBalanceByUserIdService;

    @GetMapping(path = "/usdt/user/{userId}")
    public ResponseEntity<FutureBalanceDTO> getLatestFutureBalanceByUserId(@PathVariable Long userId) {
        FutureBalanceDTO dto = getFutureBalanceByUserIdService.execute(userId);

        return ResponseEntity.ok().body(dto);
    }

}
