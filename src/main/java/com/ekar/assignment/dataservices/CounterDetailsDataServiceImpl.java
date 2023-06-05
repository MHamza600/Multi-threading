package com.ekar.assignment.dataservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.assignment.model.CounterDetails;
import com.ekar.assignment.repository.CounterDetailsRepository;

import java.util.*;

@Service
public class CounterDetailsDataServiceImpl implements CounterDeatailsDataService {

	@Autowired
	CounterDetailsRepository repo;

	@Override
	public void logRequestIntoDB(String threadName, Integer value) {
		CounterDetails details = new CounterDetails();
		details.setRequestTime(new Date());
		details.setThreadName(threadName);
		details.setThreadValue(value);
		repo.save(details);
	}

}
