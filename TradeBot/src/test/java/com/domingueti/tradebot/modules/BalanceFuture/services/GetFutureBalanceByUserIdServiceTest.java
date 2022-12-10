package com.domingueti.tradebot.modules.BalanceFuture.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.BalanceFuture.dtos.FutureBalanceDTO;
import com.domingueti.tradebot.modules.BalanceFuture.repositories.FutureBalanceRepository;
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
public class GetFutureBalanceByUserIdServiceTest {

    private Long invalidUserId;

    private Long userId;
    private FutureBalanceDTO validFutureBalanceDTO;

    @InjectMocks
    private GetFutureBalanceByUserIdService service;

    @Mock
    private FutureBalanceRepository futureBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        userId = 1L;
        validFutureBalanceDTO = Factory.createFutureBalanceDTO();
        when(service.execute(userId)).thenReturn(validFutureBalanceDTO);

        //invalid gets
        invalidUserId = 9999L;
        doThrow(NotFoundException.class).when(futureBalanceRepository).findTop1ByInvestment_userIdOrderByReferenceDateDesc(invalidUserId);
    }

    @Test
    @DisplayName("Must return the latest existing FutureBalanceDTO")
    public void getShouldReturnLatestDTOIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(userId);
        });
        verify(futureBalanceRepository, times(1)).findTop1ByInvestment_userIdOrderByReferenceDateDesc(userId);
    }

    @Test
    @DisplayName("Should throw NotFoundException if UserID is invalid.")
    public void getShouldThrowNotFoundExceptionWhenUserIdDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
           service.execute(invalidUserId);
        });

        verify(futureBalanceRepository, times(1)).findTop1ByInvestment_userIdOrderByReferenceDateDesc(invalidUserId);
    }
}
