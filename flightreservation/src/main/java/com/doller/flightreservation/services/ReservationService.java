package com.doller.flightreservation.services;

import com.doller.flightreservation.dto.ReservationRequest;
import com.doller.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
