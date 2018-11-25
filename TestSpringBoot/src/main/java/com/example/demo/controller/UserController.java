package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserListResponse;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="/hello" , method = RequestMethod.GET)
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping(value="/users/{id}" , method = RequestMethod.GET)
	public User getUserByUid(@PathVariable String id) {
		if (!ObjectUtils.isEmpty(userService.getUserById(id))){
			return userService.getUserById(id);
		}else {
			User userN = new User();
			 userN.setErrorMessage("Resource Not Found");
			 return userN;
		}
	}
	
	@RequestMapping(value="/users" , method = RequestMethod.GET)
	public UserListResponse getAllUsers() {
		UserListResponse userRes = new UserListResponse();
		List<User> userList= userService.getAllUsers();
		if (!CollectionUtils.isEmpty(userList)){
			userRes.setCount(userList.size());
			userRes.setUserList(userList);
			return userRes;
		}else {
			 userRes.setErrorMessage("Resource Not Found");
			 return userRes;
		}
	}
	
	@RequestMapping(value="/users" , method = RequestMethod.POST)
	public User getUserByName(@RequestBody User user) {
		
		if (userValidator.validateUser(user)) {
		return userService.addUser(user);
		}
		else {
			User userN = new User();
			 userN.setErrorMessage("Error creating user");
			 return userN;
		}
	}
	
	@RequestMapping(value="/users/{id}" , method = RequestMethod.DELETE)
	public String deleteuserById(@PathVariable String id) {
		
		if (userService.deleteById(id)) {
		return "Deleted user with "+id+" successfully";
		}
		else {
			return "Some Error occurred. Unable to delete.";
		}
	}

}
