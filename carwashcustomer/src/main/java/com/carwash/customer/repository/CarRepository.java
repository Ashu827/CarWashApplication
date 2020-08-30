package com.carwash.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.customer.model.CarDetails;

@Repository
public interface CarRepository extends MongoRepository<CarDetails, String>{

}
