package com.ifuture.service.web.service;

import com.ifuture.service.aop.annotation.CollectStatistics;
import com.ifuture.service.domain.repository.AccountRepository;
import com.ifuture.service.domain.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.ifuture.service.config.CachingConfig.AMOUNTS_CACHE_NAME;
import static com.ifuture.service.domain.entity.Account.account;
import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository repository;
	private final CacheManager cacheManager;

	@SneakyThrows
	@CollectStatistics
	public void addAmount(int id, long amount) {
		log.info("Add amount: {} to database for id: {}", amount, id);
		repository.save(account(id, amount));
		ofNullable(cacheManager.getCache(AMOUNTS_CACHE_NAME))
				.ifPresent(cache -> cache.evict(id));
	}

	@SneakyThrows
	@CollectStatistics
	@Cacheable(value = AMOUNTS_CACHE_NAME, key = "#id")
	public Long getAmount(int id) {
		log.info("Get amount from database for id: {}", id);
		return repository.findById(id)
				.map(Account::getAmount)
				.orElse(0L);
	}

}
