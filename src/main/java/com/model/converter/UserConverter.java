package com.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.configuration.UserConfiguration;
import com.model.entityes.User;
import com.model.entityes.dto.UserDto;

@Component
public class UserConverter {

	@Autowired
	private UserConfiguration configuration;

	/*
	 * UserDto converte to User
	 */

	public User dtoToUser(UserDto userDto) {
		User user = this.configuration.modelMapper().map(userDto, User.class);
		return user;
	}
	
	/*
	 * User convert to user Dto 
	 */
	public UserDto userToDto(User user) {
		UserDto userDto = this.configuration.modelMapper().map(user, UserDto.class);
		return userDto ;
	}

}
