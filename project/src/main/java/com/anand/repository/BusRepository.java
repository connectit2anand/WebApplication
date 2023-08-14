package com.anand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.anand.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{

	
	
	List<Bus> findByBusNumber(String busNumber);
	
	

	
}
