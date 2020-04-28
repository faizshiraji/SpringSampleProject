package com.doller.flightcheckin.integration;

import com.doller.flightcheckin.integration.dto.Reservation;
import com.doller.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
