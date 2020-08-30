package com.carwash.customer.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = CarDetails.class)
@Document(collection="CarDetails")
public class CarDetails {

	private String name;
	private String emailId;
	private String contactNumber;
	private String carModel;
	private String carType;
	private String serviceType;
	private String preferredTime;
	private String message;
	private String address;
	private String subscription;
	
	public CarDetails() {
		
	}

	public CarDetails(String name, String emailId, String contactNumber, String carModel, String carType,
			String serviceType, String preferredTime, String message, String address, String subscription) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.carModel = carModel;
		this.carType = carType;
		this.serviceType = serviceType;
		this.preferredTime = preferredTime;
		this.message = message;
		this.address = address;
		this.subscription = subscription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	
	
}
