package com.ifuture.service.web.service;

import com.ifuture.service.domain.repository.OperationStatisticsRepository;
import com.ifuture.service.domain.repository.PerformanceStatisticsRepository;
import com.ifuture.service.web.dto.StatisticDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ifuture.service.web.dto.StatisticDTO.dto;

@Service
@RequiredArgsConstructor
public class StatisticsService {

	private final OperationStatisticsRepository operationRepository;
	private final PerformanceStatisticsRepository performanceRepository;

	public long getAllOperationCalls(String operation) {
		return operationRepository.countAllByOperation(operation);
	}

	public List<StatisticDTO> getOperationPerformance() {
		return performanceRepository.findAll().stream()
				.map(v -> dto(v.getStartTime(), v.getEndTime(), v.getAddAmountCount(), v.getGetAmountCount()))
				.collect(Collectors.toList());
	}

	public void reset() {
		operationRepository.deleteAll();
		performanceRepository.deleteAll();
	}

}
