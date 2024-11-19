package com.gmail.umarosman77.pft.services;

import com.gmail.umarosman77.pft.models.User;

public interface UserService {
	User getUser(int id);

	User createUser(User user);
}
