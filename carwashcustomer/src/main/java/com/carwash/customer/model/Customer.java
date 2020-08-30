package com.carwash.customer.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Register")
public class Customer {

	@Id
	private String emailId;
	private String name;
	@NotNull
	private String password;
	private CarDetails cardetails;
	
	public Customer() {
		
	}

	public Customer(String emailId, String name, @NotNull String password, CarDetails cardetails) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.cardetails = cardetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CarDetails getCardetails() {
		return cardetails;
	}

	public void setCardetails(CarDetails cardetails) {
		this.cardetails = cardetails;
	}

	@Override
	public String toString() {
		return "Customer [emailId=" + emailId + ", name=" + name + ", password=" + password + ", cardetails=" + cardetails + "]";
	}

	
	
	
}