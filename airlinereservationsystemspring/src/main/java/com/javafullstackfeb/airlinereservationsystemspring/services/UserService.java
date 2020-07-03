package com.javafullstackfeb.airlinereservationsystemspring.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;

public interface UserService {
	public List<FlightsInfo> searchBySource(String source);

	public List<FlightsInfo> searchByName(String flightName);

	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination);

	public List<FlightsInfo> getAllFlightDetails();

	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo);

	public boolean cancelTicket(int bookingId);

}
