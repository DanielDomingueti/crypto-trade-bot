package com.domingueti.tradebot.modules.BalanceFuture.controllers;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.FutureBalanceDTO;
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

    private GetFutureBalanceServiceByUserId getFutureBalanceServiceByUserId;

    @GetMapping(path = "/usdt/user/{userId}")
    public ResponseEntity<FutureBalanceDTO> getLatestFutureBalanceByUserId(@PathVariable Long userId) {

        return null;
    }

}
