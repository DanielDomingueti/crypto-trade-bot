package com.domingueti.tradebot.modules.Position.models;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
import com.domingueti.tradebot.modules.TradeHistory.models.TradeHistory;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "tb_open_position")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_open_position set deleted_at = current_timestamp where id=?")
public class OpenPosition implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long businessFutureBalanceId;

	private @Getter @Setter Long openPositionTypeId;

	private @Getter @Setter Long pairSymbolTypeId;

	private @Getter @Setter Long tradeHistoryId;

	private @Getter @Setter Integer leverage;

	private @Getter @Setter BigDecimal size;

	private @Getter @Setter BigDecimal entryPrice;

	private @Getter @Setter BigDecimal stopLoss;

	private @Getter @Setter BigDecimal takeProfit;

	private @Getter @Setter BigDecimal liquidityPrice;

	private @Getter @Setter BigDecimal margin;

	private @Getter @Setter Double roe;

	private @Getter @Setter LocalDate referenceDate;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "businessFutureBalanceId", insertable = false, updatable = false)
	private @Getter BsFutureBalance businessFutureBalance;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "openPositionTypeId", insertable = false, updatable = false)
	private @Getter OpenPositionType openPositionType;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "pairSymbolTypeId", insertable = false, updatable = false)
	private @Getter PairSymbolType pairSymbolType;

	@ToString.Exclude
	@OneToOne(mappedBy = "tradeHistory")
	@JoinColumn(name = "tradeHistoryId", insertable = false, updatable = false)
	private @Getter TradeHistory tradeHistory;

}
