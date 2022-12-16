package com.domingueti.tradebot.modules.Document.services;

import com.domingueti.tradebot.exceptions.InvalidRequestException;
import com.domingueti.tradebot.modules.Document.dtos.DocumentInsertDTO;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Document.repositories.DocumentRepository;
import com.domingueti.tradebot.modules.Document.validators.InsertDocumentValidator;
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
public class InsertDocumentsServiceTest {

    private Document validDocument;
    private DocumentInsertDTO validDocumentInsertDTO;

    private Document invalidDocument;
    private DocumentInsertDTO invalidDocumentInsertDTO;

    @InjectMocks
    private InsertDocumentsService service;

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private InsertDocumentValidator validator;

    @BeforeEach
    void setup() {
        //valid insert
        validDocument = Factory.createDocument();
        validDocumentInsertDTO = Factory.createDocumentInsertDTO();
        when(documentRepository.save((Document) any())).thenReturn(validDocument);
        doNothing().when(validator).execute(List.of(validDocumentInsertDTO));

        //invalid insert
        invalidDocumentInsertDTO = Factory.createDocumentInsertDTO();
        invalidDocumentInsertDTO.setUserId(0L);
        doThrow(InvalidRequestException.class).when(validator).execute(List.of(invalidDocumentInsertDTO));
    }

    @Test
    @DisplayName("Must insert list of valid documents")
    public void insertShouldSaveListOfValidDocuments() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute(List.of(validDocumentInsertDTO));
        });
        verify(documentRepository, times(1)).saveAll(any());
    }

    @Test
    @DisplayName("Must throw InvalidRequestException when document is invalid")
    public void insertShouldThrowInvalidRequestExceptionIfDocumentInsertDTOIsInvalid() {
        Assertions.assertThrows(InvalidRequestException.class, () -> {
           service.execute(List.of(invalidDocumentInsertDTO));
        });
        verify(validator, times(1)).execute(List.of(invalidDocumentInsertDTO));
        verify(documentRepository, times(0)).save(any());
    }

}
