package com.ifuture.service.statistic;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Concurrent class for storing operation's count
 */

@Service
public class OperationsCountStore {

	private final AtomicLong addAmountCounter = new AtomicLong();
	private final AtomicLong getAmountCounter = new AtomicLong();

	public void incrementAddAmount() {
		this.addAmountCounter.incrementAndGet();
	}

	public long getAddAmountCountAndReset() {
		return this.addAmountCounter.getAndSet(0);
	}

	public void incrementGetAmount() {
		this.getAmountCounter.incrementAndGet();
	}

	public long getAmountCountAndReset() {
		return this.getAmountCounter.getAndSet(0);
	}

}
