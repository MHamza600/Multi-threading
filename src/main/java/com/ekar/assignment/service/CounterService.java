package com.ekar.assignment.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.assignment.dataservices.CounterDeatailsDataService;

import lombok.Data;

@Data
@Service
public class CounterService {

	private volatile int counter = 50;
	private static final Object lock = new Object();
	Logger logger = LoggerFactory.getLogger("Counter Service");

	@Autowired
	CounterDeatailsDataService dataService;

	public void decreaseCounter() throws InterruptedException {
		synchronized (lock) {
			if (!isLimitReached()) {
				counter--;
				logger.info("Consumer Decreased the counter with name:" + Thread.currentThread().getName() + " : "
						+ counter);
				if (isLimitReached()) {
					performActionOnLimitReached("Consumer");
				}
			}
		}
	}

	public void increaseCounter() throws InterruptedException {
		synchronized (lock) {
			if (!isLimitReached()) {
				counter++;
				logger.info("Producer Increased the counter with name:" + Thread.currentThread().getName() + " : "
						+ counter);
				if (isLimitReached()) {
					performActionOnLimitReached("Producer");
				}
			}
		}

	}

	public void setCounter(int counterValue) {
		synchronized (lock) {
			counter = counterValue;
			logger.info("Counter Has been reset to count: "+ counter);
		}
	}

	private boolean isLimitReached() {
		if (counter == 0 || counter == 100) {
			return true;
		}
		return false;
	}

	public boolean isLimitReachedBlocked() {
		synchronized (lock) {
			return isLimitReached();
		}
	}

	private void performActionOnLimitReached(String type) throws InterruptedException {
		logger.info("Limit Reached By "+ Thread.currentThread().getName()+ " Saving Data in to DB");
		dataService.logRequestIntoDB(type + "_" + Thread.currentThread().getName(), counter);
	}

}
