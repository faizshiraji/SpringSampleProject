package com.doller.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doller.flightreservation.dto.ReservationRequest;
import com.doller.flightreservation.entities.Flight;
import com.doller.flightreservation.entities.Passenger;
import com.doller.flightreservation.entities.Reservation;
import com.doller.flightreservation.repos.FlightRepository;
import com.doller.flightreservation.repos.PassengerRepository;
import com.doller.flightreservation.repos.ReservationRepository;
import com.doller.flightreservation.util.EmailUtil;
import com.doller.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		// Make Payment

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "C:/Users/dolow/OneDrive/" + "doller_reservation_pdfs_"
				+ savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		System.out.println(filePath);
		return savedReservation;
	}

}