package com.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anand.entity.Bus;
import com.anand.service.BusService;


import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@PostMapping("/addBus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus){
		Bus response = busService.addBus(bus);
		return new ResponseEntity<Bus>(response,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateBus")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus){
		Bus newBus = busService.updateBus(bus);
		return new ResponseEntity<>(newBus,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public ResponseEntity<String> deleteBus(@PathVariable Integer busId){
		String response = busService.deleteBus(busId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getAllBus/{pageNumber}/{numberOfRecords}")
	public ResponseEntity<List<Bus>> getAllBus(@PathVariable Integer pageNumber,@PathVariable Integer numberOfRecords){
		List<Bus> busList = busService.getAllBus(pageNumber,numberOfRecords);
		return new ResponseEntity<>(busList,HttpStatus.ACCEPTED);
	}
	 
}
