package com.domingueti.tradebot.modules.Document.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Document.models.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long>{

	DocumentType findByIdAndDeletedAtIsNull(Long id);
	
}
