package com.ekar.assignment.threads;


import java.util.Random;

import com.ekar.assignment.service.CounterService;

public class ConsumerThread extends Thread {
	
	private CounterService countService;
	
	Random rand = new Random();
	
	public ConsumerThread(CounterService counterServiceParam) {	
	this.countService = counterServiceParam;
	}
	
	@Override
	public void run() {
		try {
			int int_random = rand.nextInt(5);
			Thread.sleep(int_random);
			countService.decreaseCounter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
