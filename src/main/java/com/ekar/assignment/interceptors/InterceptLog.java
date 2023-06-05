package com.ekar.assignment.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ekar.assignment.dataservices.RequestDeatailsDataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptLog implements HandlerInterceptor {

	@Autowired
	RequestDeatailsDataService requestDetailService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getMethod().equals(HttpMethod.GET.name()) || request.getMethod().equals(HttpMethod.DELETE.name())
				|| request.getMethod().equals(HttpMethod.PUT.name())) {
			requestDetailService.logRequestIntoDB(request);
		}
		return true;
	}
}
