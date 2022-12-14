package com.domingueti.tradebot.tests;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalanceSm;
import com.domingueti.tradebot.modules.BalanceFuture.models.FutureBalance;
import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import com.domingueti.tradebot.modules.Business.models.BsProfitBalance;
import com.domingueti.tradebot.modules.Business.models.BsProfitBalanceSm;
import com.domingueti.tradebot.modules.Business.models.BsWallet;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.models.DocumentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factory {

    public static BsFutureBalance createBsFutureBalance() {
        BsFutureBalance model = new BsFutureBalance();
        model.setId(1L);
        model.setReferenceDate(LocalDate.now());
        model.setUnits(1.0);
        model.setBalanceOriginTypeId(1L);
        model.setDeletedAt(null);
        return model;
    }

    public static BsFutureBalanceSm createBsFutureBalanceSm() {
        BsFutureBalanceSm model = new BsFutureBalanceSm();
        model.setId(1L);
        model.setUnits(1.0);
        model.setUserId(1L);
        model.setReferenceDate(LocalDate.now());
        model.setBalanceOriginTypeId(1L);
        model.setDeletedAt(null);
        return model;
    }

    public static FutureBalance createFutureBalance() {
        FutureBalance model = new FutureBalance();
        model.setId(1L);
        model.setBsFutureBalanceId(1L);
        model.setBalanceOriginTypeId(1L);
        model.setInvestmentId(1L);
        model.setNetValue(new BigDecimal("10"));
        model.setProfit(new BigDecimal("10"));
        model.setReferenceDate(LocalDate.now());
        model.setDeletedAt(null);
        return model;
    }

    public static BsSpotBalance createBsSpotBalance() {
        BsSpotBalance model = new BsSpotBalance();
        model.setId(1L);
        model.setCryptocurrencyId(1L);
        model.setBalanceOriginTypeId(1L);
        model.setProfit(new BigDecimal("10"));
        model.setNetValue(new BigDecimal("10"));
        model.setUnits(1.0);
        model.setDeletedAt(null);
        return model;
    }

    public static SpotBalance createSpotBalance() {
        SpotBalance model = new SpotBalance();
        model.setId(1L);
        model.setBsSpotBalanceId(1L);
        model.setInvestmentId(1L);
        model.setBalanceOriginTypeId(1L);
        model.setNetValue(new BigDecimal("10"));
        model.setProfit(new BigDecimal("10"));
        model.setUnits(1.0);
        model.setReferenceDate(LocalDate.now());
        model.setDeletedAt(null);
        return model;
    }

    public static BsProfitBalanceSm createBsProfitBalanceSm() {
        BsProfitBalanceSm model = new BsProfitBalanceSm();
        model.setId(1L);
        model.setNetValue(new BigDecimal("10"));
        model.setReferenceDate(LocalDate.now());
        model.setDeletedAt(null);
        return model;
    }

    public static BsWallet createBsWallet() {
        BsWallet model = new BsWallet();
        model.setId(1L);
        model.setAddress("bs_address");
        model.setDeletedAt(null);
        return model;
    }

    public static BsProfitBalance createBsProfitBalance() {
        BsProfitBalance model = new BsProfitBalance();
        model.setId(1L);
        model.setNetValue(new BigDecimal("10"));
        model.setReferenceDate(LocalDate.now());
        model.setDeletedAt(null);
        return model;
    }

    public static Cryptocurrency createCryptocurrency() {
        Cryptocurrency model = new Cryptocurrency();
        model.setId(1L);
        model.setName("bitcoin");
        model.setSymbol("BTC");
        model.setDeletedAt(null);
        return model;
    }

    public static DocumentType createDocumentType() {
        DocumentType model = new DocumentType();
        model.setId(1L);
        model.setType("cpf");
        model.setDescription("CPF");
        model.setExpirationTime(360000);
        model.setDeletedAt(null);
        return model;
    }

    public static Document createDocument() {
        Document model = new Document();
        model.setId(1L);
        model.setDocumentTypeId(1L);
        model.setMain(true);
        model.setUserId(1L);
        model.setNumber("14204938242");
        model.setDueDate(LocalDate.now().plusYears(3));
        model.setIssueDate(LocalDate.now().minusYears(2));
        model.setIssuingEntity("SSP");
        model.setDeletedAt(null);
        return model;
    }
}
