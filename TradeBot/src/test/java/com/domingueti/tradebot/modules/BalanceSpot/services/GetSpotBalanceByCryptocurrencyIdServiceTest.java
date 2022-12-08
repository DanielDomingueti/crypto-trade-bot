package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
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
public class GetSpotBalanceByCryptocurrencyIdServiceTest {

    private Long validCryptoId;
    private SpotBalanceDTO validSpotBalanceDTO;

    private Long invalidCryptoId;

    @InjectMocks
    private GetSpotBalanceByCryptocurrencyIdService service;

    @Mock
    private SpotBalanceRepository spotBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validCryptoId = 1L;
        validSpotBalanceDTO = Factory.createSpotBalanceDTO();
        when(service.execute(validCryptoId)).thenReturn(validSpotBalanceDTO);

        //invalid gets
        invalidCryptoId = 9999L;
        doThrow(NotFoundException.class).when(spotBalanceRepository).findTop1OrderByReferenceDateDescAndCryptocurrencyId(invalidCryptoId);
    }

    @Test
    @DisplayName("Must return the latest existing SpotBalanceDTO")
    public void getShouldReturnLatestDTOByCryptoIDIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validCryptoId);
        });
        verify(spotBalanceRepository, times(1)).findTop1OrderByReferenceDateDescAndCryptocurrencyId(validCryptoId);
    }

    @Test
    @DisplayName("Must throw NotFoundException when the crypto ID does not exist.")
    public void getShouldThrowNotFoundExceptionWhenCryptoIDDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            service.execute(invalidCryptoId);
        });
    }
}
