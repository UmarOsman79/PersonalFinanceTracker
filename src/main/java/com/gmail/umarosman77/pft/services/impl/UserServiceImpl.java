package com.gmail.umarosman77.pft.services.impl;

import com.gmail.umarosman77.pft.entities.UserEntity;
import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.repository.UserRepository;
import com.gmail.umarosman77.pft.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(int id) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
		UserEntity userEntity = optionalUserEntity.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MessageFormat.format("User with id: {0} not found", id)));
		return new ModelMapper().map(userEntity, User.class);
	}

	@Override
	public User createUser(User user) {
		UserEntity userEntity = new ModelMapper().map(user, UserEntity.class);
		return new ModelMapper().map(userRepository.save(userEntity), User.class);
	}
}
