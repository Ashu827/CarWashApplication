package com.carwash.customer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.carwash.customer.model.CarDetails;


@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${carwash.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${carwash.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(CarDetails cardetails) {
		rabbitTemplate.convertAndSend(exchange, routingkey, cardetails);
		System.out.println("Send msg = " + cardetails);
	    
	}

}
