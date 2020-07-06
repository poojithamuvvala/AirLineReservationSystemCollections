package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.bean.TicketBookingBean;

public interface TicketBookingDAO {

	public TicketBookingBean bookFlight(TicketBookingBean flightBooking);

	public List<TicketBookingBean> getAllBooking(String userId);
	
	public List<TicketBookingBean> getAllFlightBookings();
	
	public boolean deleteBooking(String bookingId);
}
