package com.domingueti.tradebot.modules.Business.repositories;

import com.domingueti.tradebot.modules.Business.models.BsProfitBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsProfitBalanceRepository extends JpaRepository<BsProfitBalance, Long> {
    BsProfitBalance findTop1ByDeletedAtIsNullOrderByReferenceDateDesc();
}
