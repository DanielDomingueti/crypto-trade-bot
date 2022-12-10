package com.domingueti.tradebot.modules.Investment.models;

import com.domingueti.tradebot.modules.AportHistory.models.AportHistory;
import com.domingueti.tradebot.modules.BalanceFuture.models.FutureBalance;
import com.domingueti.tradebot.modules.BalanceSpot.models.SpotBalance;
import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import com.domingueti.tradebot.modules.Income.models.IncomeType;
import com.domingueti.tradebot.modules.User.models.User;
import com.domingueti.tradebot.modules.WithdrawHistory.models.WithdrawHistory;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@OneToMany(mappedBy = "investment")
	private @Getter List<PivotInvestmentIncomeType> incomeTypes = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
	private @Getter List<AportHistory> aportHistories = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
	private @Getter List<WithdrawHistory> withdrawHistories = new ArrayList<>();

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private @Getter User user;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cryptocurrencyId", insertable = false, updatable = false)
	private @Getter Cryptocurrency cryptocurrency;

	@ToString.Exclude
	@OneToOne(optional = false)
	private @Getter SpotBalance spotBalance;

	@ToString.Exclude
	@OneToOne(optional = false)
	private @Getter FutureBalance futureBalance;

	public IncomeType getLastIncomeType() {
		List<PivotInvestmentIncomeType> currentIncomeTypes = incomeTypes.stream()
				.filter(ic -> !ic.getReferenceDate().isAfter(LocalDate.now())).collect(Collectors.toList());

		currentIncomeTypes.sort(Comparator.comparing(PivotInvestmentIncomeType::getReferenceDate));

		return currentIncomeTypes.get(currentIncomeTypes.size() - 1).getIncomeType();
	}
}
