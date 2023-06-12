package com.ekar.assignment.threads;

import com.ekar.assignment.service.CounterService;

public class ProducerThread extends Thread {

	private CounterService countService;

	public ProducerThread(CounterService counterServiceParam) {
		this.countService = counterServiceParam;
	}

	@Override
	public void run() {

		try {
			countService.increaseCounter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
