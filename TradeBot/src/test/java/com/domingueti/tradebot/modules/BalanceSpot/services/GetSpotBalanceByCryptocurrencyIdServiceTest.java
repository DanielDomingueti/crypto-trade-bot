package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
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

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetSpotBalanceByCryptocurrencyIdServiceTest {

    private Long validCryptoId;
    private SpotBalance validSpotBalance;

    private Long invalidCryptoId;

    @InjectMocks
    private GetSpotBalanceByCryptocurrencyIdService service;

    @Mock
    private SpotBalanceRepository spotBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validCryptoId = 1L;
        validSpotBalance = Factory.createSpotBalance();
        when(spotBalanceRepository.findTop1ByInvestment_cryptocurrencyIdOrderByReferenceDateDesc(validCryptoId)).thenReturn(validSpotBalance);

        //invalid gets
        invalidCryptoId = 9999L;
        doThrow(NotFoundException.class).when(spotBalanceRepository).findTop1ByInvestment_cryptocurrencyIdOrderByReferenceDateDesc(invalidCryptoId);
    }

    @Test
    @DisplayName("Must return the latest existing SpotBalanceDTO")
    public void getShouldReturnLatestDTOByCryptoIDIfExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validCryptoId);
        });
        verify(spotBalanceRepository, times(1)).findTop1ByInvestment_cryptocurrencyIdOrderByReferenceDateDesc(validCryptoId);
    }

    @Test
    @DisplayName("Must throw NotFoundException when the crypto ID does not exist.")
    public void getShouldThrowNotFoundExceptionWhenCryptoIDDoesNotExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            service.execute(invalidCryptoId);
        });
    }
}
