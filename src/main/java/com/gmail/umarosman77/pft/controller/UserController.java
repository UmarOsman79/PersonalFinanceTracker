package com.gmail.umarosman77.pft.controller;

import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Parameter for @RestController is to name the bean
//Because we're using @RestController and not @Controller, don't need to add @ResponseBody to each method
@RestController("userController")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
