package com.ifuture.service.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@Entity(name = "operation_statistics")
@NoArgsConstructor
public class OperationStatistic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String operation;
	@CreationTimestamp
	Timestamp createdDate;

	public static OperationStatistic statistic(String operation) {
		val entity = new OperationStatistic();
		entity.setOperation(operation);
		return entity;
	}

}
