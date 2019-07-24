package com.example.demo.repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	User findUserByFirstName(String firstName);
	
	User findUserByUid(String id);
	
	List<User> findAll() ;
	
	boolean existsByUid(String id) ;
	
	void deleteByUid(String id);
	
	@SuppressWarnings("unchecked")
	User save(User user);

}
