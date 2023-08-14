package com.anand.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.Bus;
import com.anand.entity.Route;
import com.anand.exception.RouteException;
import com.anand.repository.RouteRepository;
import com.anand.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService{
	
	@Autowired
	private RouteRepository routeRepository;

	@Override
	public Route addRoute(Route route) {
		
		List<Bus> busList = new ArrayList<>();
		route.setBusList(busList);
		routeRepository.save(route);
		return route;
	}

	@Override
	public Route updateRoute(Route route) {
		Integer routeId = route.getRouteID();
		Route oldRoute = routeRepository.findById(routeId).orElseThrow(()-> new RouteException("Please Enter Valid Route Id"));
		oldRoute.setDistance(route.getDistance());
		oldRoute.setRouteFrom(route.getRouteFrom());
		oldRoute.setRouteTo(route.getRouteTo());
		routeRepository.save(oldRoute);
		return route;
	}

	@Override
	public Route deleteRoute(Integer routeId) {
		Route route = routeRepository.findById(routeId).orElseThrow(()-> new RouteException("Please Enter Valid Route Id"));
		routeRepository.delete(route);
		return route;
	}

	@Override
	public List<Route> getAllRoute() {
		List<Route> busList = routeRepository.findAll();
		return busList;
	}
	
	
	
	

}
