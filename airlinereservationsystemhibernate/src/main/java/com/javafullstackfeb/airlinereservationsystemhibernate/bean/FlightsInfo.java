package com.javafullstackfeb.airlinereservationsystemhibernate.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="flightsinfo")
public class FlightsInfo implements Serializable {
	@Id
	@Column(name="flightid")
	private int flightId;
	
	@Column(name="flightsname")
	private String flightName;
	@Column
	private String source;
	@Column
	private String destination;
	@Column(name="dateofdeparture")
	private LocalDate dateOfDeparture;
	@Column(name="dateofarrival")
	private LocalDate dateOfArrival;
	@Column(name="timeofarrival")
	private LocalTime arrivalTime;
	
	@Column(name="timeofdeparture")
	private LocalTime departureTime;
	@Column
	private int capacity;
	
	@Column(name="noofseatsbooked")
	private int noOfSeatsBooked;


}

