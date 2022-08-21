package com.domingueti.tradebot.modules.User.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

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
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter Long userTypeId;
	
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
	@ManyToOne(optional = false)
	@JoinColumn(name = "userTypeId", insertable = false, updatable = false)
	private @Getter UserType userType;
	
	private @Getter CashBalance cashBalance;
	
	private @Getter List<Transaction> transactions = new ArrayList<>();
	
	@ToString.Exclude
	@ManyToMany(mappedBy = "user")
	private @Getter List<Investment> investments = new ArrayList<>();
	
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter List<InvestmentBalance> investmentBalance = new ArrayList<>();

	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter List<Document> documents = new ArrayList<>();
	
	@ToString.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_pivot_user_group_user", joinColumns = {
			@JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "userGroupId") })
	private @Getter Set<UserGroup> userGroups = new HashSet<>();
}
