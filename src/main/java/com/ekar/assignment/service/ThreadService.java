package com.ekar.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.assignment.threads.ConsumerThread;
import com.ekar.assignment.threads.ProducerThread;

@Service
public class ThreadService {

	@Autowired
	CounterService counterService;

	public void performAction(Integer consumer, Integer producer) throws InterruptedException {
		addConsumerAndProducer(consumer, producer);
	}

	public void setCounter(Integer counter) throws InterruptedException {
		counterService.setCounter(counter);
	}

	private void addConsumerAndProducer(Integer consumer, Integer producer) throws InterruptedException {
		int consumerCount = 0;
		int producerCount = 0;
		while (true) {
			if (consumerCount < consumer && !counterService.isLimitReachedBlocked()) {
				ConsumerThread consumerThread = new ConsumerThread(counterService );
				consumerThread.start();
				consumerCount++;
			}
			if (producerCount < producer && !counterService.isLimitReachedBlocked()) {
				ProducerThread producerThread = new ProducerThread(counterService);
				producerThread.start();
				producerCount++;
			}
			if((producerCount>=producer && consumerCount>=consumer) || counterService.isLimitReachedBlocked())
				break;
				
		}
	}

}
