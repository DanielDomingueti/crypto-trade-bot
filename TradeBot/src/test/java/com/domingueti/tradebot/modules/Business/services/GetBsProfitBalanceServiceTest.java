package com.domingueti.tradebot.modules.Business.services;

import com.domingueti.tradebot.modules.Business.models.BsProfitBalance;
import com.domingueti.tradebot.modules.Business.repositories.BsProfitBalanceRepository;
import com.domingueti.tradebot.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetBsProfitBalanceServiceTest {

    private BsProfitBalance validBsProfitBalance;

    @InjectMocks
    private GetBsProfitBalanceService service;

    @Mock
    private BsProfitBalanceRepository bsProfitBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validBsProfitBalance = Factory.createBsProfitBalance();
        when(bsProfitBalanceRepository.findTop1ByDeletedAtIsNullOrderByReferenceDateDesc()).thenReturn(validBsProfitBalance);
    }

    @Test
    @DisplayName("Must return the latest existing business profit balance")
    public void getShouldReturnLatestBusinessProfitBalance() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsProfitBalanceRepository, times(1)).findTop1ByDeletedAtIsNullOrderByReferenceDateDesc();
    }

}