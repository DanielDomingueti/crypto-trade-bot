package com.domingueti.tradebot.modules.Investment.models;

import com.domingueti.tradebot.modules.Income.models.IncomeType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "tb_pivot_investment_income_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "update tb_pivot_investment_income_type set deleted_at = current_timestamp where id=?")
public class PivotInvestmentIncomeType {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter Long investmentId;

    private @Getter @Setter Long incomeTypeId;

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
    @JoinColumn(name = "incomeTypeId", insertable = false, updatable = false)
    private @Getter IncomeType incomeType;
}
