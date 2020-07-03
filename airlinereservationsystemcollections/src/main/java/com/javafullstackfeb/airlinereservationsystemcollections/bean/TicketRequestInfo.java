package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class TicketRequestInfo implements Serializable{
	private int ticketid;
	private UsersInfo userInfo;
	private FlightsInfo flightInfo;
	private int noOfSeatsToBeBooked;
    private int uid;
    private int flightid;

	

}