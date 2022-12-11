package com.domingueti.tradebot.modules.Business.controllers;

import com.domingueti.tradebot.modules.Business.dtos.BsProfitBalanceDTO;
import com.domingueti.tradebot.modules.Business.dtos.BsProfitBalanceSmDTO;
import com.domingueti.tradebot.modules.Business.dtos.BsWalletDTO;
import com.domingueti.tradebot.modules.Business.services.GetBsProfitBalanceService;
import com.domingueti.tradebot.modules.Business.services.GetBsProfitBalanceSmService;
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
    private GetBsProfitBalanceService getBsProfitBalanceService;
    private GetBsProfitBalanceSmService getBsProfitBalanceSmService;

    @GetMapping("/bs/wallet")
    public ResponseEntity<BsWalletDTO> getBusinessWallet() {
        BsWalletDTO dto = getBsWalletService.execute();

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/admin/bs/profit")
    public ResponseEntity<BsProfitBalanceDTO> getBusinessProfitBalance() {
        //returns the business profit (gains from future balance)
        BsProfitBalanceDTO dto = getBsProfitBalanceService.execute();

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/admin/bs/profit/sm")
    public ResponseEntity<BsProfitBalanceSmDTO> getBusinessProfitSimulation() {
        //returns the business profit simulation (gains from future balance simulation)
        BsProfitBalanceSmDTO dto = getBsProfitBalanceSmService.execute();

        return ResponseEntity.ok().body(dto);
    }

}
