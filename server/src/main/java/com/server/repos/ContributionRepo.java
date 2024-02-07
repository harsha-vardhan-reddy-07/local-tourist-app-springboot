package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.ContributionModel;

public interface ContributionRepo extends MongoRepository<ContributionModel, String>{

    
}
