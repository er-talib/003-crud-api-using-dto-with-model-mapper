package com.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.converter.UserConverter;
import com.model.entityes.User;
import com.model.entityes.dto.UserDto;
import com.model.repository.UserRepository;
import com.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserConverter converter;

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = this.converter.dtoToUser(userDto);
		this.repository.save(user);
		return this.converter.userToDto(user);

	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user = this.converter.dtoToUser(userDto);
		this.repository.save(user);
		return this.converter.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> findAll = this.repository.findAll();
		List<UserDto> list = findAll.stream().map(user -> this.converter.userToDto(user)).collect(Collectors.toList());
		return list;
	}

	@Override
	public UserDto getOneUser(long userId) {
		User userbyId = this.repository.getById(userId);
		return this.converter.userToDto(userbyId);
	}

	@Override
	public void deleteUserById(long userId) {
		this.repository.deleteById(userId);

	}

}
