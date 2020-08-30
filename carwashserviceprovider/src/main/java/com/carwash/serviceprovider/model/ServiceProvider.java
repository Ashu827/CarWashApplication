package com.carwash.serviceprovider.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="serviceproviderdetails")

public class ServiceProvider {

	@Id
	private String emailId;
	private String name;
	@NotNull
	private String password;
	
	public ServiceProvider() {
	}

	
	public ServiceProvider(String emailId, String name, @NotNull String password) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.password = password;
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


	@Override
	public String toString() {
		return "ServiceProvider [emailId=" + emailId + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
