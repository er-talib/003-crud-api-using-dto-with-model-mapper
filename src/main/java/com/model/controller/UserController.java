package com.model.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.entityes.dto.UserDto;
import com.model.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/details")
	public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
		UserDto saveUser = this.service.saveUser(dto);
		return new ResponseEntity<UserDto>(saveUser, HttpStatus.CREATED);

	}
	
	@PutMapping("/details")
	public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
		UserDto updateUser = this.service.updateUser(dto);
		return new ResponseEntity(Map.of("message", "User details updated successfully..!!"), HttpStatus.OK);

	}
	
	@GetMapping("/details")
	public ResponseEntity<List<UserDto>> getAllUsers(){
     List<UserDto> allUsers = this.service.getAllUsers();
     return new ResponseEntity<List<UserDto>>(allUsers , HttpStatus.OK);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<UserDto> getUserById( @PathVariable long id){
		UserDto oneUser = this.service.getOneUser(id);
		return new ResponseEntity<UserDto>(oneUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/details/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		
		this.service.deleteUserById(id);
		 return new ResponseEntity<>(Map.of("message","User has been deleted successfully..!!" ),  HttpStatus.OK);
	}
	
	

}
