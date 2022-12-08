package com.domingueti.tradebot.modules.Business.controllers;

import com.domingueti.tradebot.modules.Business.dtos.BsProfitBalanceDTO;
import com.domingueti.tradebot.modules.Business.dtos.BsProfitBalanceSmDTO;
import com.domingueti.tradebot.modules.Business.dtos.BsWalletDTO;
import com.domingueti.tradebot.modules.Business.services.GetBsProfitService;
import com.domingueti.tradebot.modules.Business.services.GetBsWalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class BusinessController {

    private GetBsWalletService getBsWalletService;
    private GetBsProfitService getBsProfitService;


    @GetMapping("/business/wallet")
    public ResponseEntity<BsWalletDTO> getBusinessWallet() {
        //returns the business wallet
        return null;
    }

    @GetMapping("/admin/business/profit")
    public ResponseEntity<BsProfitBalanceDTO> getBusinessProfit() {
        //returns the business profit (gains from future balance)
        return null;
    }

    @GetMapping("/admin/business/profit/simulation")
    public ResponseEntity<BsProfitBalanceSmDTO> getBusinessProfitSimulation() {
        //returns the business profit simulation (gains from future balance simulation)
        return null;
    }

}
