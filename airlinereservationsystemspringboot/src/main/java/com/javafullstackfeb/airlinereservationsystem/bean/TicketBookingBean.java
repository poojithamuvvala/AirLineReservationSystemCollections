package com.javafullstackfeb.airlinereservationsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "flightbooking")
public class TicketBookingBean {

	@Id
	@Column
	private String bookingId;

	@Column
	private String userId;

	@Column
	@NotEmpty(message = "This field is required")
	private String firstName;

	@Column
	@NotEmpty(message = "This field is required")
	private String lastName;

	@Column(name = "flightno")
	@NotEmpty(message = "This field is required")
	private String flightNo;

	@Column(name = "arrival_city")
	@NotEmpty(message = "This field is required")
	private String arrivalCity;

	@Column(name = "departure_city")
	@NotEmpty(message = "This field is required")
	private String departureCity;

	@Column(name = "dep_date")
	@NotEmpty(message = "This field is required")
	
	private String departureDate;

	@Column(name = "arr_date")
	@NotEmpty(message = "This field is required")
	private String arrivalDate;

	@Column(name = "dep_time")
	@NotEmpty(message = "This field is required")
	private String departureTime;

	@Column(name = "arr_time")
	@NotEmpty(message = "This field is required")
	private String arrivalTime;

	@Column(name = "class_type")
	@NotEmpty(message = "This field is required")
	//@Pattern(regexp = "{A-Za-z}*")
	private String classType;

	@Column
	@Positive
	private int passengers;

	@Column
	@Positive
	private double totalFare;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	@Override
	public String toString() {
		return "FlightBooking [bookingId=" + bookingId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", flightNo=" + flightNo + ", arrivalCity=" + arrivalCity + ", departureCity=" + departureCity
				+ ", classType=" + classType + ", passengers=" + passengers + ", totalFare=" + totalFare + "]";
	}

}
