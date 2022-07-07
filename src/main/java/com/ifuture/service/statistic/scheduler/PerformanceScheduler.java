package com.ifuture.service.statistic.scheduler;

import com.ifuture.service.domain.repository.PerformanceStatisticsRepository;
import com.ifuture.service.statistic.OperationsCountStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static com.ifuture.service.domain.entity.PerformanceStatistic.statistic;

@Slf4j
@Component
@RequiredArgsConstructor
public class PerformanceScheduler {

	@Value("${statistic.performance.time-unit}")
	private Long timeUnit;
	private final PerformanceStatisticsRepository repository;
	private final OperationsCountStore operationsCountStore;

	@Scheduled(fixedDelayString = "${statistic.performance.time-unit}")
	public void execute() {
		val now = Instant.now();
		repository.save(statistic(
				now.minusMillis(timeUnit), now,
				operationsCountStore.getAddAmountCountAndReset(),
				operationsCountStore.getAmountCountAndReset()
		));
		log.info("[SCHEDULER] Performance: Save metrics");
	}

}
