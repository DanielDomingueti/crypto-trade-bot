package com.domingueti.tradebot.modules.Investment.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_investment_transaction")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_investment_transaction set deleted_at = current_timestamp where id=?")
public class InvestmentTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter Long investmentId;
	
	private @Getter @Setter Long investmentTransactionTypeId;
	
	private @Getter @Setter BigDecimal value;
	
	private @Getter @Setter Double units;
	
	private @Getter @Setter BigDecimal unitValue;
	
	private @Getter @Setter LocalDate referenceDate;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "investmentId", insertable = false, updatable = false)
	private @Getter Investment investment;
	
	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "investmentTransactionTypeId", insertable = false, updatable = false)
	private @Getter InvestmentTransactionType investmentTransactionType;
}
