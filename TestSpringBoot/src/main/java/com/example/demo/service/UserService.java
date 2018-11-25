package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.example.demo.model.User;

@Configuration
public interface UserService {
	
	User addUser (User user);

	User getUserById(String id);
	
	List<User> getAllUsers();
	
	Boolean deleteById(String id);

}
