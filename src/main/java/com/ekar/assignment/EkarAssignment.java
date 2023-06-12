package com.ekar.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ekar")
public class EkarAssignment {

	public static void main(String[] args) {
		SpringApplication.run(EkarAssignment.class, args);
	}
	
}
