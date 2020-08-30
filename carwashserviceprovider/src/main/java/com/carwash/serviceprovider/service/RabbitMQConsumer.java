package com.carwash.serviceprovider.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carwash.serviceprovider.model.CarDetails;
import com.carwash.serviceprovider.repository.ServiceProviderRepo;

@Component
public class RabbitMQConsumer {
	
	@Autowired
	ServiceProviderRepo providerRepo;
	
//	List<CarDetails> details =new ArrayList<>(); 
//	
//	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
//
//	@RabbitListener(queues = "carwash.queue")
//	public List<CarDetails> recievedMessage(CarDetails cardetails) {
//		logger.info("Recieved Message From RabbitMQ: " + cardetails);
//		details.add(cardetails);
//		return details;
// 
//	}

}
