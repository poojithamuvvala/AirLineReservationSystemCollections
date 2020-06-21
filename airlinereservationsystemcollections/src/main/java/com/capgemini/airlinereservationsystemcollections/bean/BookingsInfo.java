package com.capgemini.airlinereservationsystemcollections.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BookingsInfo {
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

	public BookingsInfo() {
		super();
	}

	public BookingsInfo(int bookingId, int userId, int flightId, String flightName, int noOfSeatsBooked, String seatNos,
			LocalDate dateOfBooking, LocalDate dateOfJourney, LocalTime arrivalTime, LocalTime departureTime,
			String source, String destination) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.flightName = flightName;
		this.noOfSeatsBooked = noOfSeatsBooked;
		this.seatNos = seatNos;
		this.dateOfBooking = dateOfBooking;
		this.dateOfJourney = dateOfJourney;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.source = source;
		this.destination = destination;
	}

}
