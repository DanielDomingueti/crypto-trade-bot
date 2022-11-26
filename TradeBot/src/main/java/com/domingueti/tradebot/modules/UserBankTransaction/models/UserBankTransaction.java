package com.domingueti.tradebot.modules.UserBankTransaction.models;

import com.domingueti.tradebot.modules.User.models.User;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "tb_user_bank_transaction")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "update tb_user_bank_transaction set deleted_at = current_timestamp where id=?")
public class UserBankTransaction implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter Long id;
	
	private @Getter @Setter Long userId;
	
	private @Getter @Setter Long userBankTransactionTypeId;

	private @Getter @Setter BigDecimal value;

	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
	@ToString.Exclude
	@OneToOne(mappedBy = "cashBalance")
	private @Getter @Setter User user;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userBankTransactionTypeId", insertable = false, updatable = false)
	private @Getter @Setter UserBankTransaction userBankTransaction;
	
}
