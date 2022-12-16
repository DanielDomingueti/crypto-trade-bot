package com.domingueti.tradebot.modules.Document.repositories;

import com.domingueti.tradebot.modules.Document.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long>{

	List<Document> findAllByUserIdAndDeletedAtIsNull(Long userId);
	
	Document findByIdAndDeletedAtIsNull(Long id);

	Boolean existsDocumentByUserId(Long userId);
	
}
