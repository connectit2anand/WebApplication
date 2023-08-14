package com.anand.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name="Bus")
@Data
public class Bus {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name="bus_id")
	    private Integer busId;
	 	
	 	@NotBlank(message = "Bus number can't be null/blank, Please provide bus number!")
	 	@Column(name="bus_numbe")
	 	private String busNumber;
	 	
	    @NotBlank(message = "Bus name can't be null/blank, Please provide a valid name first!")
	    @Column(name="bus_name")
	    private String busName;

	    @NotBlank(message = "Driver name can't be null/blank, Please provide a valid name first!")
	    @Column(name="driver_name")
	    private String driverName;

	    @NotBlank(message = "Bus Type can't be null/blank, Please provide a valid bus type")
	    @Column(name="bus_type")
	    private String busType;

	    @NotBlank(message = "Choose a valid starting point.")
	    @Column(name="route_From")
	    private String routeFrom;

	    @NotBlank(message = "Choose a valid destination.")
	    @Column(name="route_to")
	    private String routeTo;

	    @NotNull(message = "Bus Journey Date can't be null, Please provide correct date")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Column(name="bus_journey_date")
	    private LocalDate busJourneyDate;

	    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	    @Column(name="arrival_time")
	    private LocalTime arrivalTime;

	    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	    @Column(name="departure_time")
	    private LocalTime departureTime;

	    @Column(name = "total_seats")
	    private Integer seats;
	    
	    @Column(name="available_seats")
	    private Integer availableSeats;

	    @NotNull(message = "fare can't be null")
	    @Column(name="fare")
	    private Integer fare;

//	    @JsonIgnore
	    @ManyToOne
	    private Route route;

//	    @JsonIgnore
	    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
	    private List<Reservation> reservationList = new ArrayList<>();
}
