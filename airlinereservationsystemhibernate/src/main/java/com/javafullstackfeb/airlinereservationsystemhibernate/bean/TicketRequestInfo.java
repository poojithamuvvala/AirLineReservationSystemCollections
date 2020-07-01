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
@Table(name="bookticket")
public class TicketRequestInfo implements Serializable{

	private UserInfo userInfo;
	private FlightsInfo flightInfo;
	@Id
	@Column(name="bookingid")
	private int bookingId;

	

}