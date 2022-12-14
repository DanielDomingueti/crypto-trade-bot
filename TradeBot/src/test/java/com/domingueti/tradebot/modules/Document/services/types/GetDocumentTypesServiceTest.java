package com.domingueti.tradebot.modules.Document.services.types;

import com.domingueti.tradebot.modules.Document.models.DocumentType;
import com.domingueti.tradebot.modules.Document.repositories.DocumentTypeRepository;
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
public class GetDocumentTypesServiceTest {

    private DocumentType validDocumentType;

    @InjectMocks
    private GetDocumentTypesService service;

    @Mock
    private DocumentTypeRepository documentTypeRepository;

    @BeforeEach
    void setup() {
        //valid gets
        validDocumentType = Factory.createDocumentType();
        when(documentTypeRepository.findAllByDeletedAtIsNull()).thenReturn(List.of(validDocumentType));
    }

    @Test
    @DisplayName("Must return list of existing document types")
    public void getShouldReturnListOfDocumentType() {
        Assertions.assertDoesNotThrow(() -> {
            service.execute();
        });
        verify(documentTypeRepository, times(1)).findAllByDeletedAtIsNull();
    }

}