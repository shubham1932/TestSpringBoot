package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/hello" , method = RequestMethod.GET)
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping(value="/users/{name}" , method = RequestMethod.GET)
	public User getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@RequestMapping(value="/users" , method = RequestMethod.POST)
	public User getUserByName(@RequestBody User user) {
		return userService.addUser(user);
	}

}
