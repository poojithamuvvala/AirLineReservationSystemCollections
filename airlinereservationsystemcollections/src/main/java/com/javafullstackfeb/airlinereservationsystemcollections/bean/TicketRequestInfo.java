package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class TicketRequestInfo implements Serializable{
	private UsersInfo userInfo;
	private FlightsInfo flightInfo;
	private int noOfSeatsToBeBooked;

	

}