package com.anand.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{


	List<User> findByEmail(String email);

	
	

}
