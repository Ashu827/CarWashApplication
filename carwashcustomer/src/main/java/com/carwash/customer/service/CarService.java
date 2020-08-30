package com.carwash.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.customer.model.CarDetails;
import com.carwash.customer.model.Customer;
import com.carwash.customer.repository.CarRepository;

@Service
public class CarService {
	
	private static final Logger logger = LoggerFactory.getLogger(CarService.class);
	
	@Autowired
	CarRepository carRepository;
	
	String[] cars;
	
	public String saveCarDetails(CarDetails car) {
		carRepository.save(car);
		return "Car Details Saved Successfully";
	}
	
	public CarDetails getCarDetailsbyemail(Customer customer) {
		
		List<CarDetails> cardetails = carRepository.findAll(); 
		ArrayList<CarDetails> listdata = new ArrayList<CarDetails>();   
		
		Optional<CarDetails> cardemo = carRepository.findById(customer.getEmailId());
		
		for(CarDetails details : cardetails) {
			if(customer.getEmailId().equals(details.getEmailId())){
				System.out.print("details" + details);
				return details;
			}
			
		}
		return null;	
				
	}
	
	
	
}
