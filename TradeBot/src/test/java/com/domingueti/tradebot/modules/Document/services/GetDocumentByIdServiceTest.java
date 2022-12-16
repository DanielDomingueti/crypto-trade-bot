package com.domingueti.tradebot.modules.Document.services;

import com.domingueti.tradebot.exceptions.NotFoundException;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
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
public class GetDocumentByIdServiceTest {

    private Document validDocument;
    private Long validId;

    private Document invalidDocument;
    private Long invalidId;

    @InjectMocks
    private GetDocumentByIdService service;

    @Mock
    private DocumentRepository documentRepository;

    @BeforeEach
    void setup() {
        //valid get
        validId = 1L;
        validDocument = Factory.createDocument();
        when(documentRepository.findByIdAndDeletedAtIsNull(validId)).thenReturn(validDocument);

        //invalid get
        invalidId = 0L;
        invalidDocument = Factory.createDocument();
        invalidDocument.setId(invalidId);
        doThrow(NotFoundException.class).when(documentRepository).findByIdAndDeletedAtIsNull(invalidId);

    }

    @Test
    @DisplayName("Must return document whe ID exists")
    public void getShouldReturnDocumentWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validId);
        });
        verify(documentRepository, times(1)).findByIdAndDeletedAtIsNull(validId);
    }

    @Test
    @DisplayName("Must throw NotFoundException when ID does not exist")
    public void getShouldThrowNotFoundExceptionWhenIdDoesntExist() {
        Assertions.assertThrows(NotFoundException.class, () -> {
           service.execute(invalidId);
        });
        verify(documentRepository, times(1)).findByIdAndDeletedAtIsNull(invalidId);
    }
}
