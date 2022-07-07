package com.ifuture.service.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@Entity(name = "performance_statistics")
@NoArgsConstructor
public class PerformanceStatistic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Long addAmountCount;
	Long getAmountCount;
	Instant startTime;
	Instant endTime;

	public static PerformanceStatistic statistic(Instant startTime, Instant endTime, long addAmount, long getAmount) {
		val entity = new PerformanceStatistic();
		entity.setStartTime(startTime);
		entity.setEndTime(endTime);
		entity.setAddAmountCount(addAmount);
		entity.setGetAmountCount(getAmount);
		return entity;
	}

}
