package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class FlightsInfo implements Serializable {
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


}
