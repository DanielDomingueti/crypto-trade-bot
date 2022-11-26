package com.domingueti.tradebot.modules.Bank.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "tb_pix_key")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_pix_key set deleted_at = current_timestamp where id=?")
public class PixKey {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter Long id;

    private @Getter @Setter Long bankId;

    private @Getter @Setter Long pixTypeId;

    private @Getter @Setter String key;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "bankId", insertable = false, updatable = false)
    private @Getter @Setter Bank bank;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "pixTypeId", insertable = false, updatable = false)
    private @Getter @Setter PixType pixType;

}