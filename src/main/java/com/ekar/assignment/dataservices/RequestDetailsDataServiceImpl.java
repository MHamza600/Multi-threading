package com.ekar.assignment.dataservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.assignment.model.RequestDetails;
import com.ekar.assignment.repository.RequestDetailsRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class RequestDetailsDataServiceImpl implements RequestDeatailsDataService {

	@Autowired
	RequestDetailsRepository repo;

	@Override
	public void logRequestIntoDB(HttpServletRequest request) {
		Map<String, String> parameters = getParameters(request);
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setMethodCall(request.getMethod());
		requestDetails.setUrl(request.getRequestURI().toString());
		requestDetails.setRequestDate(new Date());
		if (!parameters.isEmpty()) {
			requestDetails.setParameters(parameters.toString());
		}
		repo.save(requestDetails);
	}

	private Map<String, String> getParameters(HttpServletRequest request) {
		Map<String, String> parameters = new HashMap<>();
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			String paramValue = request.getParameter(paramName);
			parameters.put(paramName, paramValue);
		}
		return parameters;
	}

}
