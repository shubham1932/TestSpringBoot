package com.example.demo.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.User;

@Configuration
public interface UserRepository extends MongoRepository<User, String>{
	
	User findUserByFirstName(String firstName);
	
	User findUserByLastName(String firstName);
	
	@SuppressWarnings("unchecked")
	User save(User user);

}
