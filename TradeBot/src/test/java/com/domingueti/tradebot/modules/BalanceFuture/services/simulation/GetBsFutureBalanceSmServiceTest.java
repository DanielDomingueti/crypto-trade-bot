package com.domingueti.tradebot.modules.BalanceFuture.services.simulation;

import com.domingueti.tradebot.modules.BalanceFuture.dtos.simulation.BsFutureBalanceSmDTO;
import com.domingueti.tradebot.modules.BalanceFuture.repositories.simulation.BsFutureBalanceSmRepository;
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
public class GetBsFutureBalanceSmServiceTest {

    private BsFutureBalanceSmDTO validBsFutureBalanceSmDTO;

    @InjectMocks
    private GetBsFutureBalanceSmService service;

    @Mock
    private BsFutureBalanceSmRepository bsFutureBalanceSmRepository;

    @BeforeEach
    void setup() {
        //valid insertions
        validBsFutureBalanceSmDTO = Factory.createBsFutureBalanceSmDTO();
        when(service.execute()).thenReturn(validBsFutureBalanceSmDTO);
    }

    @Test
    @DisplayName("Must return the latest existing BsFutureBalanceSmDTO")
    public void getShouldReturnLatestDTOIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsFutureBalanceSmRepository, times(1)).findTop1ByOrderByReferenceDateDesc();
    }
}
