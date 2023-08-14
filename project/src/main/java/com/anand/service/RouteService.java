package com.anand.service;

import java.util.List;

import com.anand.entity.Route;

public interface RouteService {

	Route addRoute(Route route);

	Route updateRoute(Route route);

	Route deleteRoute(Integer routeId);

	List<Route> getAllRoute();

}
