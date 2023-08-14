package com.anand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
