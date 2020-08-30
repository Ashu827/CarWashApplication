package com.carwash.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "car.wash.customer")
//@EnableEurekaClient
public class CarwashcustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarwashcustomerApplication.class, args);
	}

}
