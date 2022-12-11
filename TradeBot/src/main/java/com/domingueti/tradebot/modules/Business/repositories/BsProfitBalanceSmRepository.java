package com.domingueti.tradebot.modules.Business.repositories;

import com.domingueti.tradebot.modules.Business.models.BsProfitBalanceSm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsProfitBalanceSmRepository extends JpaRepository<BsProfitBalanceSm, Long> {
    BsProfitBalanceSm findTop1ByDeletedAtIsNullOrderByReferenceDateDesc();
}
