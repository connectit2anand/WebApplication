package com.anand.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Reservation {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer reservationID;
	    private String status;
	    private LocalDate date;
	    private LocalTime time;

	    private String source;
	    private String destination;
	    private LocalDate journeyDate;
	    private Integer bookedSeat;
	    private Integer fare;

	    @ManyToOne
	    private User user;

	    @ManyToOne
	    private Bus bus;
}
