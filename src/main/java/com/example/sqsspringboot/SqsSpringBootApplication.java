package com.example.sqsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SqsSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsSpringBootApplication.class, args);
	}

}
