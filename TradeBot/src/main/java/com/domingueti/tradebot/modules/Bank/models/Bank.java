package com.domingueti.tradebot.modules.Bank.models;

import com.domingueti.tradebot.modules.User.models.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_bank")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "update tb_bank set deleted_at = current_timestamp where id=?")
public class Bank {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter Long bankTypeId;

    private @Getter @Setter Long userId;

    private @Getter @Setter String agency;

    private @Getter @Setter String account;

    private @Getter @Setter String holder;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "bankTypeId", insertable = false, updatable = false)
    private @Getter BankType bankType;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private @Getter User user;

    @ToString.Exclude
    @OneToMany(mappedBy = "bank")
    private @Getter List<PixKey> pixKeys = new ArrayList<>();

}
