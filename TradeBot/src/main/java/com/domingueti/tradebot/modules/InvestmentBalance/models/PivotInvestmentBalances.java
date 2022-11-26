package com.domingueti.tradebot.modules.InvestmentBalance.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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

import com.domingueti.tradebot.modules.Investment.models.InvestmentOperationType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_pivot_investment_balances")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_pivot_investment_balances set deleted_at = current_timestamp where id=?")

public class PivotInvestmentBalances implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter Long sourceInvestmentBalanceId;
	
	private @Getter @Setter Long resultInvestmentBalanceId;
	
	private @Getter @Setter Long investmentOperationTypeId;
	
	private @Getter @Setter BigDecimal value;
	
	private @Getter @Setter Boolean simulated;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "sourceInvestmentBalanceId", insertable = false, updatable = false)
    private @Getter InvestmentBalance sourceInvestmentBalance;

	@ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "resultInvestmentBalanceId", insertable = false, updatable = false)
    private @Getter InvestmentBalance resultInvestmentBalance;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "investmentOperationTypeId", insertable = false, updatable = false)
	private @Getter InvestmentOperationType investmentOperationType;

}