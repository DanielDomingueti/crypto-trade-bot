package com.domingueti.tradebot.modules.Business.services;

import com.domingueti.tradebot.modules.Business.dtos.BsWalletDTO;
import com.domingueti.tradebot.modules.Business.models.BsWallet;
import com.domingueti.tradebot.modules.Business.repositories.BsWalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetBsWalletService {

    private BsWalletRepository bsWalletRepository;

    @Transactional(readOnly = true)
    public BsWalletDTO execute() {
        BsWallet bsWallet = bsWalletRepository.findOneByDeletedAtIsNull();

    return new BsWalletDTO(bsWallet);
    }
}
