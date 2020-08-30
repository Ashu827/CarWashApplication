package com.carwash.serviceprovider.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.carwash.serviceprovider.model.CarDetails;

@Service
public class KafkaConsumer {
	
//	 @KafkaListener(topics = "carwash_7", groupId = "group_json",
//	            containerFactory = "userKafkaListenerFactory")
//	    public void consumeJson(CarDetails carDetails) {
//	        System.out.println("Consumed JSON Message: " + carDetails);
//	    }

}
