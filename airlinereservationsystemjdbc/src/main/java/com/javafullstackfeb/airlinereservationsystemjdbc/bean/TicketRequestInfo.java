package com.javafullstackfeb.airlinereservationsystemjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class TicketRequestInfo implements Serializable{
	private UserInfo userInfo;
	private FlightsInfo flightInfo;
	private int noOfSeatsToBeBooked;

	

}