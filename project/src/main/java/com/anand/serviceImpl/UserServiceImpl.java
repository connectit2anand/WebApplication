package com.anand.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.User;
import com.anand.entity.UserDto;
import com.anand.exception.UserException;
import com.anand.repository.UserRepository;
import com.anand.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String addUser(UserDto userDto) {
		List<User> userList = userRepository.findByEmail(userDto.getEmail());
	    if(!userList.isEmpty()) {
	    	throw new UserException("User Already Exists Kindly Enter Unique Email id");
	    } 
	    String firstName = userDto.getFirstName();
    	String lastName = userDto.getLastName();
    	String email = userDto.getEmail();
    	String mobile = userDto.getMobile();
    	String password = userDto.getPassword();
    	
    	User user = new User();
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	user.setEmail(email);
    	user.setMobile(mobile);
    	user.setPassword(password);
    	userRepository.save(user);
		return "User successfully added";
	}

	@Override
	public String loginUser(String email, String password) {
		List<User> listEmail = userRepository.findByEmail(email);
		
		
		if(listEmail.size() == 0)  {
			throw new UserException("Please Enter Valid Credentail");
		}			
		User user = listEmail.get(0);
		
		if(!user.getPassword().equals(password)) {
			throw new UserException("Please Enter Valid Credentail");
		}
		return "Successfull LoggedIn";
	}
}
