package com.ifuture.service.web.dto;

import lombok.Value;

import java.time.Instant;

@Value
public class StatisticDTO {

	Instant startDate;
	Instant endDate;
	Long addAmountCount;
	Long getAmountCount;

	public static StatisticDTO dto(Instant startDate, Instant endDate, Long addAmountCount, Long getAmountCount) {
		return new StatisticDTO(startDate, endDate, addAmountCount, getAmountCount);
	}

}
