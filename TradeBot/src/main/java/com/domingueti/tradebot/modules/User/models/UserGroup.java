package com.domingueti.tradebot.modules.User.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tb_user_group")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "update tb_user_group set deleted_at = current_timestamp where id=?")
public class UserGroup implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;

	private @Getter @Setter String name;

	private @Getter @Setter String description;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_pivot_user_group_user_route", joinColumns = {
			@JoinColumn(name = "userGroupId") }, inverseJoinColumns = { @JoinColumn(name = "userRouteId") })
	private @Getter List<UserRoute> userRoutes = new ArrayList<>();
	
	@ToString.Exclude
	@ManyToMany(mappedBy = "userGroups")
	private @Getter List<User> users = new ArrayList<>();
	
}
