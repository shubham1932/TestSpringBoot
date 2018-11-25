package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.helper.IdGeneratorHelper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		user.setUid(IdGeneratorHelper.getSaltString());
		return  userRepository.save(user);
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findUserByUid(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
