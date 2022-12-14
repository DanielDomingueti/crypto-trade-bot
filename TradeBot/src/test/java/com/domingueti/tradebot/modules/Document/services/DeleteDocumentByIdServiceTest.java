package com.domingueti.tradebot.modules.Document.services;

import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.validators.DeleteDocumentByIdValidator;
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
public class DeleteDocumentByIdServiceTest {

    private Document validDocument;
    private Long validId;

    private Document invalidDocument;
    private Long invalidId;

    @InjectMocks
    private DeleteDocumentByIdService service;

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private DeleteDocumentByIdValidator validator;

    @BeforeEach
    void setup() {
        //valid delete
        validId = 1L;
        validDocument = Factory.createDocument();
        when(documentRepository.findByIdAndDeletedAtIsNull(validId)).thenReturn(validDocument);
        doNothing().when(validator).execute(validDocument);
        doNothing().when(documentRepository).delete(validDocument);

        //invalid delete
        invalidId = 0L;
        invalidDocument = Factory.createDocument();
        invalidDocument.setId(invalidId);
        when(documentRepository.findByIdAndDeletedAtIsNull(invalidId)).thenReturn(invalidDocument);
        doThrow(InvalidRequestException.class).when(validator).execute(invalidDocument);

    }

    @Test
    @DisplayName("Must return nothing and delete valid document")
    public void getShouldReturnNothingAndDeleteDocument() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(validId);
        });
        verify(documentRepository, times(1)).findByIdAndDeletedAtIsNull(validId);
        verify(validator, times(1)).execute(validDocument);
        verify(documentRepository, times(1)).delete(validDocument);
    }

    @Test
    @DisplayName("Must throw InvalidRequestException")
    public void getShouldThrowInvalidRequestException() {
        Assertions.assertThrows(InvalidRequestException.class, () -> {
           service.execute(invalidId);
        });
        verify(documentRepository, times(1)).findByIdAndDeletedAtIsNull(invalidId);
        verify(validator, times(1)).execute(invalidDocument);
        verify(documentRepository, times(0)).delete(invalidDocument);
    }
}
