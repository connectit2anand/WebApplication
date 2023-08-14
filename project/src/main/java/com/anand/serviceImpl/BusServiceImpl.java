package com.anand.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anand.entity.Bus;
import com.anand.entity.Reservation;
import com.anand.entity.Route;
import com.anand.exception.BusException;
import com.anand.repository.BusRepository;
import com.anand.repository.RouteRepository;
import com.anand.service.BusService;

@Service
public class BusServiceImpl implements BusService{

	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public Bus addBus(Bus bus) {
		List<Bus> busList = busRepository.findByBusNumber(bus.getBusNumber());
		if(busList.size() > 0) {
			throw new BusException("Please Enter Valid Bus Number");
		}
		if(bus.getAvailableSeats() > bus.getSeats()) {
			throw new BusException("Please Enter Correct Number Of Total and Available Seats");
		}
		Route route = bus.getRoute();
		busList = route.getBusList();
		busList.add(bus);
//		routeRepository.save(route); //It will cause duplication in database
		return busRepository.save(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		Bus oldBus = busRepository.findById(bus.getBusId()).orElseThrow(()-> 
				new BusException("Bus does not exist"));
		
		if(bus.getAvailableSeats() > bus.getSeats()) {
			throw new BusException("Please Enter Correct Number Of Total and Available Seats");
		}
		busRepository.save(bus);
		return bus;
	}

	@Override
	public String deleteBus(Integer busId) {
		Bus bus = busRepository.findById(busId).orElseThrow(() -> 
					new BusException("Bus does not exist.Plese Enter Valid Bus Id"));
		busRepository.delete(bus);
		return "Bus Successfully Deleted";
	}

	@Override
	public List<Bus> getAllBus(Integer pageNumber,Integer numberOfRecords) {
		Pageable p =  PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<Bus> page = busRepository.findAll(p); 
		List<Bus> buses = page.getContent();
		return buses;
	}

}
