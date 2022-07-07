package com.ifuture.service.domain.repository;

import com.ifuture.service.domain.entity.PerformanceStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceStatisticsRepository extends JpaRepository<PerformanceStatistic, Long> {
}
