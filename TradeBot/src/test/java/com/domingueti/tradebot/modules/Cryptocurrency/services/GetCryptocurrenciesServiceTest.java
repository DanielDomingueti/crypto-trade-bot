package com.domingueti.tradebot.modules.Cryptocurrency.services;

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

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetCryptocurrenciesServiceTest {

    private Cryptocurrency validCryptocurrency;

    @InjectMocks
    private GetCryptocurrenciesService service;

    @Mock
    private CryptocurrencyRepository cryptocurrencyRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validCryptocurrency = Factory.createCryptocurrency();
        when(cryptocurrencyRepository.findAllByDeletedAtIsNull()).thenReturn(List.of(validCryptocurrency));
    }

    @Test
    @DisplayName("Must return list of existing cryptocurrencies")
    public void getShouldReturnListOfCryptocurrencies() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(cryptocurrencyRepository, times(1)).findAllByDeletedAtIsNull();
    }

}