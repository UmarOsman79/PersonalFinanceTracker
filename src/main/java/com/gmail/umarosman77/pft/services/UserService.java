package com.gmail.umarosman77.pft.services;

import com.gmail.umarosman77.pft.models.User;

import java.util.List;

public interface UserService {
	User getUser(int id);

	User createUser(User user);

	List<User> getAllUsers();
}
