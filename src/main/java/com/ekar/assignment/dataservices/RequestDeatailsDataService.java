package com.ekar.assignment.dataservices;

import javax.servlet.http.HttpServletRequest;

public interface RequestDeatailsDataService {

	void logRequestIntoDB(HttpServletRequest request);
}
