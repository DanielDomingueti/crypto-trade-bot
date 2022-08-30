package com.domingueti.tradebot.modules.Document.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.tradebot.modules.Document.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
