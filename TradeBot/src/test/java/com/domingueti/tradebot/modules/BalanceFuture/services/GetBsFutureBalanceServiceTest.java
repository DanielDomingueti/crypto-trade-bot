package com.domingueti.tradebot.modules.BalanceFuture.services;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.BsFutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.repositories.BsFutureBalanceRepository;
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
public class GetBsFutureBalanceServiceTest {

    private BsFutureBalanceDTO validBsFutureBalanceDTO;

    @InjectMocks
    private GetBsFutureBalanceService service;

    @Mock
    private BsFutureBalanceRepository bsFutureBalanceRepository;

    @BeforeEach
    void setup() {
        //valid insertions
        validBsFutureBalanceDTO = Factory.createBsFutureBalanceDTO();
        when(service.execute()).thenReturn(validBsFutureBalanceDTO);
    }

    @Test
    @DisplayName("Must return the latest existing BsFutureBalanceDTO")
    public void getShouldReturnLatestDTOIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsFutureBalanceRepository, times(1)).findTop1OrderByReferenceDateDesc();
    }
}
