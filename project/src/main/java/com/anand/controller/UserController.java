package com.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.entity.UserDto;
import com.anand.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUsers")
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto){
		String response = userService.addUser(userDto);
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<String> loginUser(@PathVariable String email,@PathVariable String password){
		String response = userService.loginUser(email,password);
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
	}
}
