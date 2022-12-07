package com.domingueti.tradebot.modules.Business.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "tb_business")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "update tb_business set deleted_at = current_timestamp where id=?")
public class Business {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter Long businessWalletId;

    private @Getter @Setter Long businessProfitBalanceId;

    private @Getter @Setter Long businessProfitBalanceSimulationId;

    private @Getter @Setter String name;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @ToString.Exclude
    @OneToOne(mappedBy = "business")
    private @Getter BsWallet businessWallet;

    @ToString.Exclude
    @OneToOne(mappedBy = "business")
    private @Getter BsProfitBalance businessProfitBalance;

    @ToString.Exclude
    @OneToOne(mappedBy = "business")
    private @Getter BsProfitBalanceSm businessProfitBalanceSimulation;
}
