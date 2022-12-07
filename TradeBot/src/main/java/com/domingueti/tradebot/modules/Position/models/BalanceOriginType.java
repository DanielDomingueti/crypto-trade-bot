package com.domingueti.tradebot.modules.Position.models;

import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalance;
import com.domingueti.tradebot.modules.BalanceFuture.models.BsFutureBalanceSm;
import com.domingueti.tradebot.modules.BalanceFuture.models.FutureBalance;
import com.domingueti.tradebot.modules.BalanceSpot.models.BsSpotBalance;
import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_balance_origin_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_balance_origin_type set deleted_at = current_timestamp where id=?")
public class BalanceOriginType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter String type;
	
	private @Getter @Setter String description;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@OneToMany(mappedBy = "balanceOriginType")
	private @Getter List<SpotBalance> spotBalances = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "balanceOriginType")
	private @Getter List<BsSpotBalance> businessSpotBalances = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "balanceOriginType")
	private @Getter List<FutureBalance> futureBalances = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "balanceOriginType")
	private @Getter List<BsFutureBalance> businessFutureBalances = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "balanceOriginType")
	private @Getter List<BsFutureBalanceSm> businessFutureBalanceSimulations = new ArrayList<>();
}
