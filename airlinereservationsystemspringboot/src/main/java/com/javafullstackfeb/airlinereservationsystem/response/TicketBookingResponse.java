package com.javafullstackfeb.airlinereservationsystem.response;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.bean.TicketBookingBean;

public class TicketBookingResponse {
	private int statusCode;
	private String message;
	private String description;
	private TicketBookingBean flightBooking;
	private List<TicketBookingBean> searchFlight;
	private List<TicketBookingBean> getAllBookingInfo;

	public List<TicketBookingBean> getGetAllBookingInfo() {
		return getAllBookingInfo;
	}

	public void setGetAllBookingInfo(List<TicketBookingBean> getAllBookingInfo) {
		this.getAllBookingInfo = getAllBookingInfo;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketBookingBean getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(TicketBookingBean flightBooking) {
		this.flightBooking = flightBooking;
	}

	public List<TicketBookingBean> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<TicketBookingBean> searchFlight) {
		this.searchFlight = searchFlight;
	}

}
