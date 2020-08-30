package com.carwash.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.customer.model.CarDetails;
import com.carwash.customer.model.Customer;
import com.carwash.customer.service.CarService;
import com.carwash.customer.service.CustomerService;
import com.carwash.customer.service.RabbitMQSender;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	RabbitMQSender rabbitMQSender;
//	
//	@Autowired
//	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private KafkaTemplate<String, CarDetails> kafkaTemplate;
	
	private static final String TOPIC = "carwash_7";
	
	@ApiOperation(value = "check response and request object for Registration",notes= "registration method", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "ok"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Server error")
	}
	)
	@RequestMapping(method = RequestMethod.POST, value="/registration", produces = { "application/json" })
	public boolean addCustomer(@RequestBody Customer customer) {
		logger.info(customer + " registration customer detils");
		 return customerService.addNewCustomer(customer);
	}
	
	@ApiOperation(value = "Check request and response object for login", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "ok"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Server error")
	}
	)
	@PostMapping(value="/login")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean login(@RequestBody Customer customer) {
		System.out.print(customer);
		logger.info(customer + " login customer detils");
		return customerService.login(customer);

	}
	@ApiOperation(value = "Get car details for booking bu customer", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "ok"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Server error")
	}
	)
	@PostMapping(value="/booking")
	public CarDetails getAllCar(@RequestBody CarDetails car) {
		carService.saveCarDetails(car);
		return car;
	}
	
	@ApiOperation(value = "Get car details from DB for same customer", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "ok"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Server error")
	}
	)
	@PostMapping(value="/getcardetails")
	public CarDetails getCarDetailsbyId(@RequestBody Customer customer) {
		System.out.print(customer);
		
		rabbitMQSender.send(carService.getCarDetailsbyemail(customer));
		
//		amqpTemplate.convertAndSend("javainuseExchange", "javainuse", carService.getCarDetailsbyemail(customer));
		
//		kafkaTemplate.send(TOPIC, carService.getCarDetailsbyemail(customer));
		return carService.getCarDetailsbyemail(customer);
	}
}
