package com.domingueti.tradebot.modules.BusinessWallet.repositories;

import com.domingueti.tradebot.modules.BusinessWallet.models.BusinessWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessWalletRepository extends JpaRepository<BusinessWallet, Long> {
}
