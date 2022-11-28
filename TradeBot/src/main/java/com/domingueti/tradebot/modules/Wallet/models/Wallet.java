package com.domingueti.tradebot.modules.Wallet.models;

import com.domingueti.tradebot.modules.User.models.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "tb_wallet")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_wallet set deleted_at = current_timestamp where id=?")
public class Wallet {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter Long userId;

    private @Getter @Setter String address;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @ToString.Exclude
    @OneToOne(mappedBy = "wallet")
    private @Getter User user;

}
