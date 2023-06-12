package com.ekar.assignment.threads;


import com.ekar.assignment.service.CounterService;

public class ConsumerThread extends Thread {
	

	private CounterService countService;
	
	public ConsumerThread(CounterService counterServiceParam) {	
	this.countService = counterServiceParam;
	}
	
	@Override
	public void run() {
		try {
			countService.decreaseCounter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
