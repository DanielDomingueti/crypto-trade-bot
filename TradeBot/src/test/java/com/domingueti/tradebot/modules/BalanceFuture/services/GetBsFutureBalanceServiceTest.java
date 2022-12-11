package com.domingueti.tradebot.modules.BalanceFuture.services;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
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

    private BsFutureBalance validBsFutureBalance;

    @InjectMocks
    private GetBsFutureBalanceService service;

    @Mock
    private BsFutureBalanceRepository bsFutureBalanceRepository;

    @BeforeEach
    void setup() {
        //valid insertions
        validBsFutureBalance = Factory.createBsFutureBalance();
        when(bsFutureBalanceRepository.findTop1ByOrderByReferenceDateDesc()).thenReturn(validBsFutureBalance);
    }

    @Test
    @DisplayName("Must return the latest existing BsFutureBalanceDTO")
    public void getShouldReturnLatestDTOIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsFutureBalanceRepository, times(1)).findTop1ByOrderByReferenceDateDesc();
    }
}
