package com.domingueti.tradebot.modules.InvestmentBalance.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.domingueti.tradebot.modules.Investment.models.Investment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_investment_balance")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_investment_balance set deleted_at = current_timestamp where id=?")
public class InvestmentBalance implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter Long investmentId;
	
	private @Getter @Setter BigDecimal netValue;
	
	private @Getter @Setter Double units;
	
	private @Getter @Setter BigDecimal averageUnitValue;
	
	private @Getter @Setter BigDecimal profit;
	
	private @Getter @Setter Boolean profitable;
	
	private @Getter @Setter Boolean simulated;
	
	private @Getter @Setter LocalDate referenceDate;
		
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
	@OneToOne(mappedBy = "investmentBalance")
	private @Getter Investment investment;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "investmentBalance", cascade = CascadeType.ALL)
	private @Getter List<PivotInvestmentBalanceCashBalance> pivotInvestmentBalancesCashBalances = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "sourceInvestmentBalance", cascade = CascadeType.ALL)
	private @Getter List<PivotInvestmentBalances> sourcePivotInvestmentBalances = new ArrayList<>();
	
	@ToString.Exclude
	@OneToMany(mappedBy = "resultInvestmentBalance", cascade = CascadeType.ALL)
	private @Getter List<PivotInvestmentBalances> resultPivotInvestmentBalances = new ArrayList<>();
}
