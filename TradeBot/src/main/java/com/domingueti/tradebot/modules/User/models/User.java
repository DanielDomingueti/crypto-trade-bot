package com.domingueti.tradebot.modules.User.models;

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
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.domingueti.tradebot.modules.CashBalance.models.CashBalance;
import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Investment.models.Investment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_user set deleted_at = current_timestamp where id=?")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter Long cashBalanceId;

	private @Getter @Setter String name;

	private @Getter @Setter String email;

	private @Getter @Setter String password;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@OneToOne(optional = false)
	@JoinColumn(name = "cashBalanceId", insertable = false, updatable = false)
	private @Getter CashBalance cashBalance;
		
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter List<Investment> investments = new ArrayList<>();
	
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter List<Document> documents = new ArrayList<>();
	
	@ToString.Exclude
	@ManyToMany //originally EAGER
	@JoinTable(name = "tb_pivot_user_group_user", joinColumns = {
			@JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "userGroupId") })
	private @Getter Set<UserGroup> userGroups = new HashSet<>();
}
