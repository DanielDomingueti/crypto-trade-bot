package com.domingueti.tradebot.modules.Document.models;

import com.domingueti.tradebot.modules.User.models.User;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "tb_document")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_document set deleted_at = current_timestamp where id=?")
public class Document {
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long userId;

	private @Getter @Setter Long documentTypeId;

	private @Getter @Setter String number;
	
	private @Getter @Setter String issuingEntity;
	
	private @Getter @Setter LocalDate issueDate;
	
	private @Getter @Setter LocalDate dueDate;
	
	private @Getter @Setter Boolean main;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private @Getter User user;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "documentTypeId", insertable = false, updatable = false)
	private @Getter DocumentType documentType;
}