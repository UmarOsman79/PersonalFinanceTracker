package com.gmail.umarosman77.pft.services.impl;

import com.gmail.umarosman77.pft.entities.UserEntity;
import com.gmail.umarosman77.pft.exception.PftException;
import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.repository.UserRepository;
import com.gmail.umarosman77.pft.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		UserEntity userEntity = new ModelMapper().map(user, UserEntity.class);
		return new ModelMapper().map(userRepository.save(userEntity), User.class);
	}
}
