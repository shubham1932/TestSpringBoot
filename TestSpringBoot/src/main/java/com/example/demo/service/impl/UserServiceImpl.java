package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		user.setLastName("sssss");
		return  userRepository.save(user);
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.findUserByLastName(name);
	}

}
