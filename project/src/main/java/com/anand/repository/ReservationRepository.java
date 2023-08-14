package com.anand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
