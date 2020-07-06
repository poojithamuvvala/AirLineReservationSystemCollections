package com.javafullstackfeb.airlinereservationsystem.service;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.bean.TicketBookingBean;
import com.javafullstackfeb.airlinereservationsystem.bean.FlightInformationBean;

public interface FlightService {

	public FlightInformationBean getFlight(String flightNumber);

	public boolean addFlight(FlightInformationBean flightInformation);

	public boolean updateFlight(FlightInformationBean flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightInformationBean> search(String departureCity, String arrivalCity, String departureDate);

	public List<FlightInformationBean> getAllFlights();

	public TicketBookingBean bookFlight(TicketBookingBean flightBooking);

	public List<TicketBookingBean> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
	
	public List<FlightInformationBean> searchFlight(String departureCity, String arrivalCity);
	
	public List<TicketBookingBean> getAllFlightBookings();
}
