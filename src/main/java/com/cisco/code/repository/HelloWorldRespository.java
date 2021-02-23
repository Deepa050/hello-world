package com.cisco.code.repository;


import com.cisco.code.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HelloWorldRespository extends MongoRepository<User,Integer> {


}
