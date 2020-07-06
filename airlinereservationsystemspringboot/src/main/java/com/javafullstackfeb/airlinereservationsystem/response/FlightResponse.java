package com.javafullstackfeb.airlinereservationsystem.response;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.bean.FlightInformationBean;

public class FlightResponse {
	private int statusCode;
	private String message;
	private String description;
	private String bookingid;
	private double totalFare;
	private FlightInformationBean flightInformation;
	private List<FlightInformationBean> searchFlight;

	
	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
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

	public FlightInformationBean getFlightInformation() {
		return flightInformation;
	}

	public void setFlightInformation(FlightInformationBean flightInformation) {
		this.flightInformation = flightInformation;
	}

	public List<FlightInformationBean> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<FlightInformationBean> searchFlight) {
		this.searchFlight = searchFlight;
	}

}
