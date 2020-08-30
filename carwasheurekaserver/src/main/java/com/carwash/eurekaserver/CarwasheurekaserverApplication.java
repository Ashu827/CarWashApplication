package com.carwash.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CarwasheurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarwasheurekaserverApplication.class, args);
	}

}
