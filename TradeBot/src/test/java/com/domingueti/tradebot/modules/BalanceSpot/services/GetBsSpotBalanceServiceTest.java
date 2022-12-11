package com.domingueti.tradebot.modules.BalanceSpot.services;

import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.repositories.BsSpotBalanceRepository;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Cryptocurrency.repositories.CryptocurrencyRepository;
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
public class GetBsSpotBalanceServiceTest {

    private Long validCryptoId;
    private BsSpotBalance validBsSpotBalance;
    private Cryptocurrency cryptocurrency;

    private Long invalidCryptoId;

    @InjectMocks
    private GetBsSpotBalanceService service;

    @Mock
    private BsSpotBalanceRepository bsSpotBalanceRepository;

    @Mock
    private CryptocurrencyRepository cryptocurrencyRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validCryptoId = 1L;
        validBsSpotBalance = Factory.createBsSpotBalance();
        cryptocurrency = Factory.createCryptocurrency();
//        when(cryptocurrencyRepository.findAllByDeletedAtIsNull()).thenReturn(List.of(cryptocurrency));
        when(bsSpotBalanceRepository.findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(validCryptoId)).thenReturn(validBsSpotBalance);

        invalidCryptoId = 9999L;
        doThrow(NullPointerException.class).when(bsSpotBalanceRepository).findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(invalidCryptoId);

    }

    @Test
    @DisplayName("Must return the summarized BsSpotBalanceDTO")
    public void getShouldReturnSummarizedDTO() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsSpotBalanceRepository, times(1)).findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(validCryptoId);
    }

    @Test
    @DisplayName("Must throw NotFoundException if CryptoID does not exist")
    public void getShouldThrowNotFoundExceptionIfCryptoIdDoesntExist() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            service.execute();
        });

        verify(bsSpotBalanceRepository, times(0)).findTop1ByCryptocurrencyIdOrderByReferenceDateDesc(invalidCryptoId);
    }

}
