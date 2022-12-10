package com.domingueti.tradebot.modules.Income.models;

import com.domingueti.tradebot.modules.Investment.models.PivotInvestmentIncomeType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "tb_income_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "update tb_income_type set deleted_at = current_timestamp where id=?")
public class IncomeType {

    @Id
    @EqualsAndHashCode.Include
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
    @OneToMany(mappedBy = "incomeType")
    private @Getter List<PivotInvestmentIncomeType> pivotInvestmentIncomeTypes;

}
