package com.domingueti.tradebot.modules.BalanceFuture.models;

import com.domingueti.tradebot.modules.Position.models.BalanceOriginType;
import com.domingueti.tradebot.modules.Position.models.OpenPosition;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_bs_future_balance")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_bs_future_balance set deleted_at = current_timestamp where id=?")
public class BsFutureBalance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long balanceOriginTypeId;

	private @Getter @Setter Double units;

	private @Getter @Setter LocalDate referenceDate;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "balanceOriginTypeId", insertable = false, updatable = false)
	private @Getter BalanceOriginType balanceOriginType;

	@ToString.Exclude
	@OneToMany(mappedBy = "bsFutureBalance")
	private @Getter List<FutureBalance> futureBalances = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "bsFutureBalance")
	private @Getter List<OpenPosition> openPositions = new ArrayList<>();

}
