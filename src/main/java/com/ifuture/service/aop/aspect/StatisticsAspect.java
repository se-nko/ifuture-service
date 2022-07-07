package com.ifuture.service.aop.aspect;

import com.ifuture.service.domain.repository.OperationStatisticsRepository;
import com.ifuture.service.statistic.OperationsCountStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import static com.ifuture.service.domain.entity.OperationStatistic.statistic;

/**
 *  Aspect collects statistic of methods' callings
 */

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class StatisticsAspect {

	private static final String ADD_AMOUNT = "addAmount";
	private static final String GET_AMOUNT = "getAmount";
	private final OperationStatisticsRepository repository;
	private final OperationsCountStore operationsCountStore;

	@Before("@annotation(com.ifuture.service.aop.annotation.CollectStatistics)")
	public void beforeAdvice(JoinPoint joinPoint) {
		try {
			val signature = (MethodSignature) joinPoint.getSignature();
			val operation = signature.getMethod().getName();
			if (ADD_AMOUNT.equals(operation)) {
				operationsCountStore.incrementAddAmount();
			}
			if (GET_AMOUNT.equals(operation)) {
				operationsCountStore.incrementGetAmount();
			}
			repository.save(statistic(operation));
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}



}
