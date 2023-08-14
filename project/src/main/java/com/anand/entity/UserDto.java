package com.anand.entity;

import lombok.Data;

@Data
public class UserDto {
	
	private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
}
