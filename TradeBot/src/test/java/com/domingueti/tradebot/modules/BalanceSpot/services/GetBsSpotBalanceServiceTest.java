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
public class GetBsSpotBalanceServiceTest {

    private Long validCryptoId;
    private BsSpotBalanceDTO validBsSpotBalanceDTO;

    private Long invalidCryptoId;

    @InjectMocks
    private GetBsSpotBalanceService service;

    @Mock
    private BsSpotBalanceRepository bsSpotBalanceRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validCryptoId = 1L;
        validBsSpotBalanceDTO = Factory.createBsSpotBalanceDTO();
        when(service.execute()).thenReturn(validBsSpotBalanceDTO);

        invalidCryptoId = 9999L;
        doThrow(NotFoundException.class).when(bsSpotBalanceRepository).findTop1OrderByReferenceDateDescAndCryptocurrencyId(invalidCryptoId);

    }

    @Test
    @DisplayName("Must return the summarized BsSpotBalanceDTO")
    public void getShouldReturnSummarizedDTO() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsSpotBalanceRepository, times(1)).findTop1OrderByReferenceDateDescAndCryptocurrencyId(validCryptoId);
    }

    @Test
    @DisplayName("Must throw NotFoundException if CryptoID does not exist")
    public void getShouldThrowNotFoundExceptionIfCryptoIdDoesntExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            service.execute();
        });

        verify(bsSpotBalanceRepository, times(1)).findTop1OrderByReferenceDateDescAndCryptocurrencyId(invalidCryptoId);
    }

}
