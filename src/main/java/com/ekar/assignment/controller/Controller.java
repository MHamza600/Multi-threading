package com.ekar.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekar.assignment.service.ThreadService;

@RestController
public class Controller {

	@Autowired
	ThreadService threadService;

	@GetMapping(path = "/createThreads")
	public ResponseEntity<?> StartThread(@RequestParam("consumer") String consumer,
			@RequestParam("producer") String producer) {
		try {
			Integer producers = Integer.parseInt(producer);
			Integer consumers = Integer.parseInt(consumer);
			if (producers < 0 || consumers < 0)
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			threadService.performAction(consumers, producers);
		} catch (NumberFormatException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (InterruptedException interuptionException) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping(path = "/setCounter")
	public ResponseEntity<?> ResetCounter(@RequestParam("count") String count) {
		try {
			Integer counter = Integer.parseInt(count);
			threadService.setCounter(counter);
		} catch (NumberFormatException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (InterruptedException interuptionException) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
