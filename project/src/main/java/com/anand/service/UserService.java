package com.anand.service;

import com.anand.entity.UserDto;

import jakarta.validation.Valid;

public interface UserService {

	String addUser(@Valid UserDto userDto);

	String loginUser(String email, String password);
	
}
