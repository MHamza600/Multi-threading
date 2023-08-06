package com.ekar.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekar.assignment.Exception.CustomException;
import com.ekar.assignment.service.ThreadService;

@RestController
public class Controller {

	@Autowired
	ThreadService threadService;

	@GetMapping(path = "/createThreads")
	public ResponseEntity<?> StartThread(@RequestParam("consumer") String consumer,
			@RequestParam("producer") String producer) {
		try {
			validateConsumerProducer(producer, consumer);
			threadService.performAction(Integer.parseInt(consumer), Integer.parseInt(consumer));
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), e.getStatus());
		}
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping(path = "/setCounter")
	public ResponseEntity<?> ResetCounter(@RequestParam("count") String count) {
		try {
			Integer counter = Integer.parseInt(count);
			threadService.setCounter(counter);
		} catch (NumberFormatException e) {
			return new ResponseEntity<>("Error in parsing Params", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	void validateConsumerProducer(String producer, String consumer) throws CustomException {
		try {
			Integer producerValue = Integer.parseInt(producer);
			Integer consumerValue = Integer.parseInt(consumer);
			if (producerValue < 0 || consumerValue < 0)
				throw new CustomException("Bad Request", HttpStatus.BAD_REQUEST, 400);
		} catch (NumberFormatException e) {
			throw new CustomException("Invalid Params producer/Consumer", HttpStatus.BAD_REQUEST, 402);
		}
	}
}
