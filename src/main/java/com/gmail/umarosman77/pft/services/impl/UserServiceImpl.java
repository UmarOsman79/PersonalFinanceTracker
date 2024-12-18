package com.gmail.umarosman77.pft.services.impl;

import com.gmail.umarosman77.pft.entities.UserEntity;
import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.repository.UserRepository;
import com.gmail.umarosman77.pft.services.UserService;
import com.gmail.umarosman77.pft.util.PftUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

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

	@Override
	public List<User> getAllUsers() {
		return PftUtil.mapList(userRepository.findAll(), User.class);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = this.getUser(id);
		userRepository.delete(new ModelMapper().map(user, UserEntity.class));
	}
}
