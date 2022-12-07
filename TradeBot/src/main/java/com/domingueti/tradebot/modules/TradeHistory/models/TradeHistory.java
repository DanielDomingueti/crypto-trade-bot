package com.domingueti.tradebot.modules.TradeHistory.models;

import com.domingueti.tradebot.modules.Position.models.OpenPosition;
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

@Entity(name = "tb_trade_history")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_trade_history set deleted_at = current_timestamp where id=?")
public class TradeHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long openPositionId;

	private @Getter @Setter BigDecimal price; //sold at

	private @Getter @Setter BigDecimal size; //margin * leverage

	private @Getter @Setter Double fee;

	private @Getter @Setter Double roe;

	private @Getter @Setter LocalDate referenceDate;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@OneToOne(mappedBy = "openPosition")
	@JoinColumn(name = "openPositionId", insertable = false, updatable = false)
	private @Getter OpenPosition openPosition;

}
