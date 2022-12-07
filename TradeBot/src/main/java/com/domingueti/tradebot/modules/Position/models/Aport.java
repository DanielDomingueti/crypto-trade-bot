package com.domingueti.tradebot.modules.Position.models;

import com.domingueti.tradebot.modules.Cryptocurrency.models.Cryptocurrency;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "tb_aport")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "update tb_aport set deleted_at = current_timestamp where id=?")
public class Aport {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;

    private @Getter @Setter Long cryptocurrencyId;

    private @Getter @Setter BigDecimal value;

    private @Getter @Setter LocalDate referenceDate;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "cryptocurrencyId", insertable = false, updatable = false)
    private @Getter Cryptocurrency cryptocurrency;

}