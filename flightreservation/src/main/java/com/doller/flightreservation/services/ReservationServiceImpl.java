package com.doller.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 
	@Value("${com.doller.flightreservation.itinarary.dirpath}")
	private String ITINERARY_DIR;

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

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {

		LOGGER.info("Inside bookFlight()");
		// Make Payment

		Long flightId = request.getFlightId();

		LOGGER.info("Fetching flight for flight Id: " + flightId);
		
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation: " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + "doller_reservation_pdfs_"
				+ savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		System.out.println(filePath);
		return savedReservation;
	}

}
