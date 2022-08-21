package com.domingueti.tradebot.modules.Investment.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.domingueti.tradebot.modules.User.models.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_investment")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_investment set deleted_at = current_timestamp where id=?")
public class Investment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long userId;

	private @Getter @Setter Long cryptocurrencyId;

	private @Getter @Setter BigDecimal initialValue;

	private @Getter @Setter BigDecimal unitValue;

	private @Getter @Setter Double units;

	private @Getter @Setter Boolean active;

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
	@ManyToOne(optional = false)
	@JoinColumn(name = "cryptocurrencyId", insertable = false, updatable = false)
	private @Getter Cryptocurrency cryptocurrency;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "investmentBalanceId")
	private @Getter InvestmentBalance investmentBalance;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
	private @Getter List<InvestmentTransaction> investmentTransactions;

}
