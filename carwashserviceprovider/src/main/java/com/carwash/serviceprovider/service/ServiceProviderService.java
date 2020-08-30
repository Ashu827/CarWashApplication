package com.carwash.serviceprovider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carwash.serviceprovider.model.ServiceProvider;
import com.carwash.serviceprovider.repository.ServiceProviderRepo;

@Service
public class ServiceProviderService {

	@Autowired
	ServiceProviderRepo providerRepo;

	public boolean addNewCustomer(ServiceProvider provider) {

		if (providerRepo.existsById(provider.getEmailId())) {
			return false;
		}

		providerRepo.save(provider);
		return true;

	}

	public boolean login(ServiceProvider provider) {
		List<ServiceProvider> users = providerRepo.findAll();

		for (ServiceProvider user : users) {
			if (user.getEmailId().equals(provider.getEmailId()) && user.getPassword().equals(provider.getPassword())) {
				return true;
			}

		}
		return false;
	}
}
