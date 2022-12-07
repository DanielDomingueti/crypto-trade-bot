package com.domingueti.tradebot.modules.BalanceSpot.models;

import com.domingueti.tradebot.modules.Position.models.BalanceOriginType;
import com.domingueti.tradebot.modules.Investment.models.Investment;
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

@Entity(name = "tb_spot_balance")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_spot_balance set deleted_at = current_timestamp where id=?")
public class SpotBalance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long investmentId;

	private @Getter @Setter Long businessSpotBalanceId;

	private @Getter @Setter Long balanceOriginTypeId;

	private @Getter @Setter BigDecimal netValue;

	private @Getter @Setter Double units;

	private @Getter @Setter BigDecimal profit;

	private @Getter @Setter LocalDate referenceDate;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "investmentId")
	private @Getter Investment investment;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "businessSpotBalanceId", insertable = false, updatable = false)
	private @Getter BsSpotBalance businessSpotBalance;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "balanceOriginTypeId", insertable = false, updatable = false)
	private @Getter BalanceOriginType balanceOriginType;
}
