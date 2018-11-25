package com.example.demo.service;

import org.springframework.context.annotation.Configuration;

import com.example.demo.model.User;

@Configuration
public interface UserService {
	
	User addUser (User user);

	User getUserByName(String name);

}
