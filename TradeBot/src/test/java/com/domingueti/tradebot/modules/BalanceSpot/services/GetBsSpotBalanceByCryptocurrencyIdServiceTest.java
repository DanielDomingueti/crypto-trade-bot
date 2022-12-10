package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.BalanceSpot.dtos.BsSpotBalanceDTO;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.BsSpotBalanceRepository;
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
public class GetBsSpotBalanceByCryptocurrencyIdServiceTest {

    private Long validCryptoId;
    private BsSpotBalanceDTO validBsSpotBalanceDTO;

    private Long invalidCryptoId;

    @InjectMocks
    private GetBsSpotBalanceByCryptocurrencyIdService service;

    @Mock
    private BsSpotBalanceRepository bsSpotBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validCryptoId = 1L;
        validBsSpotBalanceDTO = Factory.createBsSpotBalanceDTO();
        when(service.execute(validCryptoId)).thenReturn(validBsSpotBalanceDTO);

        //invalid gets
        invalidCryptoId = 9999L;
        doThrow(NotFoundException.class).when(bsSpotBalanceRepository).findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(invalidCryptoId);
    }

    @Test
    @DisplayName("Must return the latest existing BsSpotBalanceDTO")
    public void getShouldReturnLatestDTOByCryptoIDIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validCryptoId);
        });
        verify(bsSpotBalanceRepository, times(1)).findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(validCryptoId);
    }

    @Test
    @DisplayName("Must throw NotFoundException when the crypto ID does not exist.")
    public void getShouldThrowNotFoundExceptionWhenCryptoIDDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            service.execute(invalidCryptoId);
        });
    }
}
