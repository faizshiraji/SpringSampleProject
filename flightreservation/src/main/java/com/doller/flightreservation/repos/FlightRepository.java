package com.doller.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
