package com.model.entityes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	private long id;
	private String name;
	private String email;
	private String address;
	private String phone;

}
