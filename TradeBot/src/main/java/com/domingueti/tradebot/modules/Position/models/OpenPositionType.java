package com.domingueti.tradebot.modules.Position.models;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_open_position_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_open_position_type set deleted_at = current_timestamp where id=?")
public class OpenPositionType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
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
	@OneToMany(mappedBy = "openPositionType")
	private @Getter List<OpenPosition> openPositions = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "openPositionType")
	private @Getter List<OpenPositionSm> openPositionSimulations = new ArrayList<>();

}
