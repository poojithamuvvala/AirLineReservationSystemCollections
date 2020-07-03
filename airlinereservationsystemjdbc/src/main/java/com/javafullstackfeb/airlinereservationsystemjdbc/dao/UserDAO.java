package com.javafullstackfeb.airlinereservationsystemjdbc.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;

public interface UserDAO {

	public List<FlightsInfo> searchFlightByName(String flightName);

	public List<FlightsInfo> searchFlightBySource(String source);

	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination);
	
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo);
	
	public List<FlightsInfo> getAllFlightDetails();

	
	public boolean cancelTicket(int bookingId);

	
	
	
}
