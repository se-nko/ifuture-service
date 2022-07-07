package com.ifuture.service.domain.repository;

import com.ifuture.service.domain.entity.OperationStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationStatisticsRepository extends JpaRepository<OperationStatistic, Long> {

	Long countAllByOperation(String operation);

}
