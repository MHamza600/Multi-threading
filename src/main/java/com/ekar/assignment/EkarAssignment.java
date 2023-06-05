package com.ekar.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ekar")
public class EkarAssignment {

	public static void main(String[] args) {
		SpringApplication.run(EkarAssignment.class, args);
	}
	
    @Bean(name = "threadExecutor")
    ExecutorService threadExecutor() {
        return Executors.newFixedThreadPool(100);
    }

	
}
