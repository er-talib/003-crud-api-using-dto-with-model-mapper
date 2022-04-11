package com.model.service;

import java.util.List;

import com.model.entityes.dto.UserDto;

public interface UserService {
	
	public UserDto saveUser(UserDto userDto);
	public UserDto updateUser(UserDto userDto);
	public List<UserDto> getAllUsers();
	public UserDto getOneUser(long userId);
	public void deleteUserById(long userId);
//	public void deleteAllUser();

}
