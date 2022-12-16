package com.domingueti.tradebot.modules.Document.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.validators.GetDocumentsByUserIdValidator;
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
public class GetDocumentsByUserIdServiceTest {

    private Document validDocument;
    private Long validUserId;

    private Document invalidDocument;
    private Long invalidUserId;

    @InjectMocks
    private GetDocumentsByUserIdService service;

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private GetDocumentsByUserIdValidator validator;

    @BeforeEach
    void setup() {
        //valid get
        validUserId = 1L;
        validDocument = Factory.createDocument();
        when(documentRepository.findAllByUserIdAndDeletedAtIsNull(validUserId)).thenReturn(List.of(validDocument));

        //invalid get
        invalidUserId = 0L;
        invalidDocument = Factory.createDocument();
        invalidDocument.setId(invalidUserId);
        doThrow(NotFoundException.class).when(documentRepository).findAllByUserIdAndDeletedAtIsNull(invalidUserId);

    }

    @Test
    @DisplayName("Must return documents when User ID exists")
    public void getShouldReturnDocumentsWhenUserIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validUserId);
        });
        verify(documentRepository, times(1)).findAllByUserIdAndDeletedAtIsNull(validUserId);
    }

    @Test
    @DisplayName("Must throw NotFoundException when User ID does not exist")
    public void getShouldThrowNotFoundExceptionWhenUserIdDoesntExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
           service.execute(invalidUserId);
        });
        verify(documentRepository, times(1)).findAllByUserIdAndDeletedAtIsNull(invalidUserId);
    }
}
