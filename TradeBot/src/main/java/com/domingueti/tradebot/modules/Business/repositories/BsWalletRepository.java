package com.domingueti.tradebot.modules.Business.repositories;

import com.domingueti.tradebot.modules.Business.models.BsWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsWalletRepository extends JpaRepository<BsWallet, Long> {
    BsWallet findOneByDeletedAtIsNull();
}
