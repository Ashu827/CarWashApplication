package com.carwash.serviceprovider.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.serviceprovider.model.ServiceProvider;

public interface ServiceProviderRepo extends MongoRepository<ServiceProvider, String>{

}
