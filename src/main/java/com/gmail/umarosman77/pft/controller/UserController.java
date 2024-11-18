package com.gmail.umarosman77.pft.controller;

import com.gmail.umarosman77.pft.exception.PftException;
import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
