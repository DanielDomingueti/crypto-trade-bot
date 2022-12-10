package com.domingueti.tradebot.modules.Income.repositories;

import com.domingueti.tradebot.modules.Income.models.IncomeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeTypeRepository extends JpaRepository<IncomeType, Long> {
}
