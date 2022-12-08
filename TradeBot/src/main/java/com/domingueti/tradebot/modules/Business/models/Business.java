package com.domingueti.tradebot.modules.Business.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "tb_bs")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "update tb_bs set deleted_at = current_timestamp where id=?")
public class Business {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter Long bsWalletId;

    private @Getter @Setter Long bsProfitBalanceId;

    private @Getter @Setter Long bsProfitBalanceSmId;

    private @Getter @Setter String name;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @ToString.Exclude
    @OneToOne(mappedBy = "bs")
    private @Getter BsWallet bsWallet;

    @ToString.Exclude
    @OneToOne(mappedBy = "bs")
    private @Getter BsProfitBalance bsProfitBalance;

    @ToString.Exclude
    @OneToOne(mappedBy = "bs")
    private @Getter BsProfitBalanceSm bsProfitBalanceSm;
}
