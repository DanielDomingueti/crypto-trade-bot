package com.domingueti.tradebot.modules.Business.services;

import com.domingueti.tradebot.modules.Business.models.BsWallet;
import com.domingueti.tradebot.modules.Business.repositories.BsWalletRepository;
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
public class GetBsWalletServiceTest {

    private BsWallet validBsWallet;

    @InjectMocks
    private GetBsWalletService service;

    @Mock
    private BsWalletRepository bsWalletRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validBsWallet = Factory.createBsWallet();
        when(bsWalletRepository.findOneByDeletedAtIsNull()).thenReturn(validBsWallet);

    }

    @Test
    @DisplayName("Must return the existing business wallet dto")
    public void getShouldReturnExistingBusinessWallet() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(bsWalletRepository, times(1)).findOneByDeletedAtIsNull();
    }

}
