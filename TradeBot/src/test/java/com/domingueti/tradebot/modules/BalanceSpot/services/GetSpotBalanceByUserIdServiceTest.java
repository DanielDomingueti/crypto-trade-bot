package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.SpotBalanceRepository;
import com.domingueti.tradebot.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetSpotBalanceByUserIdServiceTest {

    private Long validUserId;
    private SpotBalance validSpotBalance;

    private Long invalidUserId;

    @InjectMocks
    private GetSpotBalanceByUserIdService service;

    @Mock
    private SpotBalanceRepository spotBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validUserId = 1L;
        validSpotBalance = Factory.createSpotBalance();
        when(spotBalanceRepository.findAllTop1ByInvestment_userIdOrderByReferenceDateDesc(validUserId)).thenReturn(List.of(validSpotBalance));

    }

    @Test
    @DisplayName("Must return the latest existing SpotBalanceDTO")
    public void getShouldReturnLatestDTOByCryptoIDIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validUserId);
        });
        verify(spotBalanceRepository, times(1)).findAllTop1ByInvestment_userIdOrderByReferenceDateDesc(validUserId);
    }

}
