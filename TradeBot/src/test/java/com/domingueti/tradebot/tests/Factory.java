package com.domingueti.tradebot.tests;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.BsFutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.dtos.FutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation.BsFutureBalanceSmDTO;
import com.domingueti.tradebot.modules.BalanceSpot.dtos.BsSpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.dtos.SpotBalanceDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factory {

    public static BsFutureBalanceDTO createBsFutureBalanceDTO() {
        BsFutureBalanceDTO dto = new BsFutureBalanceDTO();
        dto.setUnits(1.0);
        dto.setReferenceDate(LocalDate.now());
        return dto;
    }

    public static BsFutureBalanceSmDTO createBsFutureBalanceSmDTO() {
        BsFutureBalanceSmDTO dto = new BsFutureBalanceSmDTO();
        dto.setUnits(1.0);
        dto.setReferenceDate(LocalDate.now());
        return dto;
    }

    public static FutureBalanceDTO createFutureBalanceDTO() {
        FutureBalanceDTO dto = new FutureBalanceDTO();
        dto.setNetValue(new BigDecimal("1.0"));
        dto.setUnits(1.0);
        dto.setProfit(new BigDecimal("1.0"));
        dto.setReferenceDate(LocalDate.now());
        return dto;
    }

    public static BsSpotBalanceDTO createBsSpotBalanceDTO() {
        BsSpotBalanceDTO dto = new BsSpotBalanceDTO();
        dto.setNetValue(new BigDecimal("1.0"));
        dto.setUnits(1.0);
        dto.setProfit(new BigDecimal("1.0"));
        dto.setReferenceDate(LocalDate.now());
        return dto;
    }

    public static SpotBalanceDTO createSpotBalanceDTO() {
        SpotBalanceDTO dto = new SpotBalanceDTO();
        dto.setNetValue(new BigDecimal("1.0"));
        dto.setUnits(1.0);
        dto.setProfit(new BigDecimal("1.0"));
        dto.setReferenceDate(LocalDate.now());
        return dto;
    }
}
