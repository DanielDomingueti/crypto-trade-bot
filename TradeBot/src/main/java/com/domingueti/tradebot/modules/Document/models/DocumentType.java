package com.domingueti.tradebot.modules.Document.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_document_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_document_type set deleted_at = current_timestamp where id=?")
public class DocumentType {
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter String type;
	
	private @Getter @Setter String description;

	private @Getter @Setter Integer expirationTime;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@Nullable
	@ToString.Exclude
	@OneToMany(mappedBy = "documentType")
	private @Getter List<Document> documents = new ArrayList<>();
	
}