package com.domingueti.tradebot.modules.Document.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Document.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

	List<Document> findAllByUserIdAndDeletedAtIsNull(Long userId);
	
	List<Document> findAllByDeletedAtIsNull();
	
	Document findByIdAndDeletedAtIsNull(Long id);
	
}
