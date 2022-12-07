package com.domingueti.tradebot.modules.Position.repositories;

import com.domingueti.tradebot.modules.Position.models.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {

}
