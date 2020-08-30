package com.carwash.serviceprovider.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.serviceprovider.model.CarDetails;
import com.carwash.serviceprovider.model.ServiceProvider;
import com.carwash.serviceprovider.service.RabbitMQConsumer;
import com.carwash.serviceprovider.service.ServiceProviderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/serviceprovider")
public class ServiceProviderController {

	@Autowired
	private ServiceProviderService providerService;

	@Autowired
	RabbitMQConsumer rabbitMQConsumer;

	List<CarDetails> details = new ArrayList<>();

	private static final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

	@ApiOperation(value = "check response and request object for Registration", notes = "registration method", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Server error") })
	@PostMapping(value = "/registration")
	private boolean register(@RequestBody ServiceProvider provider) {
		System.out.print(provider);
		return providerService.addNewCustomer(provider);

	}

	@ApiOperation(value = "Check request and response object for login", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Server error") })
	@PostMapping(value = "/login")
	private boolean login(@RequestBody ServiceProvider provider) {
		System.out.print(provider);
		return providerService.login(provider);
	}

	@ApiOperation(value = "get booking cardetails of customer ", response = Iterable.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Server error") })
	@GetMapping(value = "/getbookingdetails")
	private List<CarDetails> get() {
		return details;
	}

	@RabbitListener(queues = "carwash.queue")
	@SendTo("detail")
	public List<CarDetails> recievedMessage(CarDetails cardetails) {
		logger.info("Recieved Message From RabbitMQ: " + cardetails);
		details.add(cardetails);
		return details;

	}

}
