package com.capgemini.airlinereservationsystemcollections.bean;

import lombok.Data;

@Data
public class TicketRequestInfo {
	private UsersInfo userInfo;
	private FlightsInfo flightInfo;
	private int noOfSeatsToBeBooked;

	public TicketRequestInfo() {
		super();
	}

	public TicketRequestInfo(UsersInfo userInfo, FlightsInfo flightInfo, int noOfSeatsToBeBooked) {
		super();
		this.userInfo = userInfo;
		this.flightInfo = flightInfo;
		this.noOfSeatsToBeBooked = noOfSeatsToBeBooked;
	}

}
