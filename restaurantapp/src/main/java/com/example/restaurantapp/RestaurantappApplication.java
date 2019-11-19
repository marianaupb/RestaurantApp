package com.example.restaurantapp;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantappApplication {
	private static final org.slf4j.Logger logger = 
			LoggerFactory.getLogger(RestaurantappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestaurantappApplication.class, args);
		logger.info("Hello, Mari!");
	}

}
