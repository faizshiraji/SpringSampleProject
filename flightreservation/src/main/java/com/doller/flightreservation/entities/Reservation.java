package com.doller.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
//import javax.persistence.Table;

@Entity
//@Table(name = "reservation")
public class Reservation extends AbstractEntity{

	private Boolean checkedId;
	private int numberOfBags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;

	public Boolean getCheckedId() {
		return checkedId;
	}
	public void setCheckedId(Boolean checkedId) {
		this.checkedId = checkedId;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}

