package com.domingueti.tradebot.modules.User.models;

import com.domingueti.tradebot.modules.Document.models.Document;
import com.domingueti.tradebot.modules.Investment.models.Investment;
import com.domingueti.tradebot.modules.Wallet.models.Wallet;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "tb_user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "update tb_user set deleted_at = current_timestamp where id=?")
public class User {
	
	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter Long walletId;
	
	private @Getter @Setter Long userTypeId;
	
	private @Getter @Setter String name;

	private @Getter @Setter String email;

	private @Getter @Setter String password;
	
	private @Getter @Setter Boolean isAdmin;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;

	@ToString.Exclude
	@OneToOne(mappedBy = "user")
	private @Getter Wallet wallet;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "userTypeId", insertable = false, updatable = false)
	private @Getter UserType userType;
		
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter List<Investment> investments = new ArrayList<>();
	
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private @Getter List<Document> documents = new ArrayList<>();
	
	@ToString.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_pivot_user_group_user", joinColumns = {
			@JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "userGroupId") })
	private @Getter Set<UserGroup> userGroups = new HashSet<>();
}
