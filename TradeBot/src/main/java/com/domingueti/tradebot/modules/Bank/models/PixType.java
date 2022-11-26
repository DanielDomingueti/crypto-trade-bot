package com.domingueti.tradebot.modules.Bank.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_pix_type")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update tb_pix_type set deleted_at = current_timestamp where id=?")
@Where(clause = "deleted_at IS NULL")
public class PixType {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter Long id;

    private @Getter @Setter String type;

    private @Getter @Setter String description;

    @CreationTimestamp
    private @Getter Timestamp createdAt;

    @UpdateTimestamp
    private @Getter Timestamp updatedAt;

    private @Getter @Setter Timestamp deletedAt;

    @Nullable
    @OneToMany(mappedBy = "pixType")
    private @Getter List<PixKey> pixKeys = new ArrayList<>();

}