package com.ekar.assignment.threads;

import com.ekar.assignment.service.CounterService;

public class ProducerThread implements Runnable {

	CounterService counterservice;

	public ProducerThread(CounterService counterService) {
		this.counterservice = counterService;

	}

	@Override
	public void run() {

		try {
			counterservice.increaseCounter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
