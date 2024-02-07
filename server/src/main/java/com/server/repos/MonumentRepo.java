package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.MonumentModel;

public interface MonumentRepo extends MongoRepository<MonumentModel, String>{

}

