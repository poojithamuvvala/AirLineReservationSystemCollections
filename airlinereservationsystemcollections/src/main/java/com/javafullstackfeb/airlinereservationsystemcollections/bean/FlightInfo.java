package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class FlightInfo {
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private LocalDate dateOfDeparture;
	private LocalDate dateOfArrival;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private int capacity;
	private int noOfSeatsBooked;

	public FlightInfo() {
		super();
	}

	public FlightInfo(int flightId, String flightName, String source, String destination, LocalDate dateOfDeparture,
			LocalDate dateOfArrival, LocalTime arrivalTime, LocalTime departureTime, int capacity,
			int noOfSeatsBooked) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.dateOfDeparture = dateOfDeparture;
		this.dateOfArrival = dateOfArrival;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.capacity = capacity;
		this.noOfSeatsBooked = noOfSeatsBooked;
	}

}
