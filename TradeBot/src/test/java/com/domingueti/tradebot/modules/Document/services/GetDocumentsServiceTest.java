package com.domingueti.tradebot.modules.Document.services;

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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetDocumentsServiceTest {

    private Document validDocument;
    private PageImpl<Document> page;

    @InjectMocks
    private GetDocumentsService service;

    @Mock
    private DocumentRepository documentRepository;

    @BeforeEach
    void setup() {
        //valid get
        validDocument = Factory.createDocument();
        page = new PageImpl<>(List.of(validDocument));
        when(documentRepository.findAll((Pageable) any())).thenReturn(page);

    }

    @Test
    @DisplayName("Must return page of existing documents")
    public void getShouldReturnExistingDocuments() {
        Pageable pageable = PageRequest.of(0, 10);

        Assertions.assertDoesNotThrow(() -> {
            service.execute(pageable);
        });
        verify(documentRepository, times(1)).findAll(pageable);
    }

}
