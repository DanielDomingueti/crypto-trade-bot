package com.domingueti.tradebot.modules.Cryptocurrency.models;

import com.domingueti.tradebot.modules.Investment.models.Investment;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_cryptocurrency")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "update tb_cryptocurrency set deleted_at = current_timestamp where id=?")
public class Cryptocurrency {

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter String symbol;

	private @Getter @Setter String name;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "cryptocurrency", cascade = CascadeType.ALL)
	private @Getter List<Investment> investments = new ArrayList<>();
}
