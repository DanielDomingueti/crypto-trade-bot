package com.domingueti.tradebot.modules.Business.services;

import com.domingueti.tradebot.modules.Business.models.BsProfitBalanceSm;
import com.domingueti.tradebot.modules.Business.repositories.BsProfitBalanceSmRepository;
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
public class GetBsProfitBalanceSmServiceTest {

    private BsProfitBalanceSm validBsProfitBalanceSm;

    @InjectMocks
    private GetBsProfitBalanceSmService service;

    @Mock
    private BsProfitBalanceSmRepository bsProfitBalanceSmRepository;

    @BeforeEach
    void setup() {
        //valid fetch
        validBsProfitBalanceSm = Factory.createBsProfitBalanceSm();
        when(bsProfitBalanceSmRepository.findTop1ByDeletedAtIsNullOrderByReferenceDateDesc()).thenReturn(validBsProfitBalanceSm);
    }

    @Test
    @DisplayName("Must return the latest existing business profit balance simulation")
    public void getShouldReturnLatestBusinessProfitBalanceSimulation() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsProfitBalanceSmRepository, times(1)).findTop1ByDeletedAtIsNullOrderByReferenceDateDesc();
    }


}
