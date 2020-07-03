package com.javafullstackfeb.airlinereservationsystemhibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "ticketbooking")
public class TicketRequestInfo implements Serializable {

//	@Column
//	private UserInfo userInfo;
//	@Column
//	private FlightsInfo flightInfo;
	@Id
	@Column(name = "bookingid")
	private int ticketid;

	@Column(name = "noofseats")
	private int noOfSeatsToBeBooked;
	@Column
	private int uid;

	@Column(name = "fid")
	private int flightid;

}