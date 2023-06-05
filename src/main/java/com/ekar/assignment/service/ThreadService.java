package com.ekar.assignment.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ekar.assignment.threads.ConsumerThread;
import com.ekar.assignment.threads.ProducerThread;

@Service
public class ThreadService {

	@Autowired
	CounterService counterService;

	@Qualifier("threadExecutor")
	@Autowired
	ExecutorService threadExecutor;

	public void performAction(Integer consumer, Integer producer) throws InterruptedException {
		addConsumer(consumer);
		addProducer(producer);
		threadExecutor.awaitTermination(0, TimeUnit.MILLISECONDS);
	}

	public void setCounter(Integer counter) throws InterruptedException {
		if(threadExecutor.isShutdown())
		threadExecutor= Executors.newFixedThreadPool(100);
		counterService.setCounter(counter);
	}

	private void addConsumer(Integer consumer) throws InterruptedException {
		if (!counterService.isLimitReachedBlocked() && !threadExecutor.isShutdown() )
			for (int i = 0; i < consumer; i++) {
				threadExecutor.execute(new ConsumerThread(counterService));
			}
	}

	private void addProducer(Integer producer) throws InterruptedException {
		if (!counterService.isLimitReachedBlocked() && !threadExecutor.isShutdown())
			for (int i = 0; i < producer; i++) {
				threadExecutor.execute(new ProducerThread(counterService));
			}
	}

}
