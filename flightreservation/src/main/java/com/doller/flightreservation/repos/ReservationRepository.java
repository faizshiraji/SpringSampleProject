package com.doller.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
