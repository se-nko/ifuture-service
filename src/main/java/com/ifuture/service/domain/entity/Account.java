package com.ifuture.service.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "accounts")
@NoArgsConstructor
public class Account {

	@Id Integer id;
	Long amount;

	public static Account account(Integer id, long amount) {
		val entity = new Account();
		entity.setId(id);
		entity.setAmount(amount);
		return entity;
	}

}
