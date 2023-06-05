package com.ekar.assignment.threads;

import com.ekar.assignment.service.CounterService;

import lombok.Synchronized;

public class ConsumerThread implements Runnable {

	private CounterService counterservice;

	public ConsumerThread(CounterService counterservice) {
		this.counterservice = counterservice;
	}

	@Override
	public void run() {
		try {
			counterservice.decreaseCounter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
