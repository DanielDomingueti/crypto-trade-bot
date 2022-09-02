package com.domingueti.tradebot.modules.Admin.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.domingueti.tradebot.modules.Document.models.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_admin")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_admin set deleted_at = current_timestamp where id=?")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter String name;

	private @Getter @Setter String email;

	private @Getter @Setter String password;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private @Getter List<Document> documents = new ArrayList<>();
	
	@ToString.Exclude
	@ManyToMany //fetch = FetchType.EAGER
	@JoinTable(name = "tb_pivot_admin_group_admin", 
		joinColumns = @JoinColumn(name="adminId"),
		inverseJoinColumns = @JoinColumn(name = "adminGroupId"))
	private @Getter Set<AdminGroup> adminGroups = new HashSet<>();
}
