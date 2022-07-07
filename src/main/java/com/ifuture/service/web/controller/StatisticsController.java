package com.ifuture.service.web.controller;

import com.ifuture.service.web.dto.StatisticDTO;
import com.ifuture.service.web.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class StatisticsController {

	private final StatisticsService service;

	@Operation(description = "Получение общего кол-ва вызовов методов")
	@Parameter(name = "operation", required = true, description = "addAmount|getAmount")
	@GetMapping("/statistics/{operation}/calls-count")
	@ResponseBody
	public Long getAllOperationCalls(@NotNull @PathVariable String operation) {
		return service.getAllOperationCalls(operation);
	}

	@Operation(description = "Получение кол-ва запросов, обрабатываемых в единицу времени")
	@GetMapping("/statistics/operation/performance")
	@ResponseBody
	public List<StatisticDTO> getOperationPerformance() {
		return service.getOperationPerformance();
	}

	@Operation(description = "Сброс статистики")
	@GetMapping("/statistics/reset")
	@ResponseBody
	public void reset() {
		service.reset();
	}

}
