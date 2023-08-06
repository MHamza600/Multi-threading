package com.ekar.assignment.Exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
    private final Integer code;
	 public CustomException(String errorMessage,HttpStatus status,Integer code) {
	        super(errorMessage);
	        this.status = status;
	        this.code = code;
	    }
}
