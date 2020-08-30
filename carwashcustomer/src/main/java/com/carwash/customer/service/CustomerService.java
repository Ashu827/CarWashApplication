package com.carwash.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.customer.controller.CustomerController;
import com.carwash.customer.model.Customer;
import com.carwash.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	public boolean addNewCustomer(Customer customer) {

		if (customerRepository.existsById(customer.getEmailId())) {
			return false;
		}

		customerRepository.save(customer);
		return true;

	}

	public boolean login(Customer customer) {
//		customerRepository.findAll();
		List<Customer> users=customerRepository.findAll();
		Optional<Customer> cred = customerRepository.findById(customer.getEmailId());

		for (Customer user : users) {
			if (user.getEmailId().equals(customer.getEmailId()) &&
					  user.getPassword().equals(customer.getPassword())) {
				return true;
			}

		}
		return false;
	}
	
	public List<Customer> getAllUser() {
		return customerRepository.findAll();
	}
	

}
