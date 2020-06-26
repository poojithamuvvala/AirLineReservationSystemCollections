package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BookingsInfo implements Serializable {
	private int bookingId;
	private int userId;
	private int flightId;
	private String flightName;
	private int noOfSeatsBooked;
	private String seatNos;
	private LocalDate dateOfBooking;
	private LocalDate dateOfJourney;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private String source;
	private String destination;

	

}
