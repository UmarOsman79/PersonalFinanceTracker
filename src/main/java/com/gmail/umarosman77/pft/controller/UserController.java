package com.gmail.umarosman77.pft.controller;

import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Parameter for @RestController is to name the bean
//Because we're using @RestController and not @Controller, don't need to add @ResponseBody to each method
@RestController("userController")
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		User user = userService.getUser(id);
		userService.deleteUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
