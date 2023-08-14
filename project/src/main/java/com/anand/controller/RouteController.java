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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.entity.Route;
import com.anand.service.RouteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	@PostMapping("/addRoute")
	public ResponseEntity<Route> addRoute(@RequestBody Route route){
		Route response = routeService.addRoute(route);
		return new ResponseEntity<Route>(response,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateRoute")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route){
		Route response = routeService.updateRoute(route);
		return new ResponseEntity<Route>(response,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteRoute/{routeId}")
	public ResponseEntity<Route> deleteRoute(@PathVariable Integer routeId){
		Route response = routeService.deleteRoute(routeId);
		return new ResponseEntity<Route>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getAllRoute")
	public ResponseEntity<List<Route>> getAllRoute(){
		List<Route> response = routeService.getAllRoute();
		return new ResponseEntity<List<Route>>(response,HttpStatus.OK);
	}
}
