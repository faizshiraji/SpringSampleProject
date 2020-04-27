package com.doller.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
