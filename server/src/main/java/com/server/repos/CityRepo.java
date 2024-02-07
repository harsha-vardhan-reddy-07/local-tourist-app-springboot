package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.CityModel;

public interface CityRepo extends MongoRepository<CityModel, String>{

    
} 
