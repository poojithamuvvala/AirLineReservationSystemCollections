package com.javafullstackfeb.airlinereservationsystemjdbc.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;

public interface UserService {

	public List<FlightsInfo> searchBySource(String source);

	public List<FlightsInfo> searchByName(String flightName);

	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination);

	public List<FlightsInfo> getAllFlightDetails();

	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo);

	public boolean cancelTicket(int bookingId);

}
