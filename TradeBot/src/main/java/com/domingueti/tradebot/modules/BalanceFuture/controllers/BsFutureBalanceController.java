package com.domingueti.tradebot.modules.BalanceFuture.controllers;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.BsFutureBalanceDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/businessFutureBalance")
public class BsFutureBalanceController {

    private GetBsFutureBalanceService getBusinessFutureBalanceService;

    @GetMapping
    public ResponseEntity<BsFutureBalanceDTO> getLatestBusinessFutureBalance() {

        return null;
    }

}
