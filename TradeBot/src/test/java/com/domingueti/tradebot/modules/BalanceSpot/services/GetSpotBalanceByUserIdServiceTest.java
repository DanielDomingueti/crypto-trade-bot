package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.dtos.SpotBalanceDTO;
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

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetSpotBalanceByUserIdServiceTest {

    private Long validUserId;
    private SpotBalanceDTO validSpotBalanceDTO;

    private Long invalidUserId;

    @InjectMocks
    private GetSpotBalanceByUserIdService service;

    @Mock
    private SpotBalanceRepository spotBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validUserId = 1L;
        validSpotBalanceDTO = Factory.createSpotBalanceDTO();
        when(service.execute(validUserId)).thenReturn(validSpotBalanceDTO);

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
