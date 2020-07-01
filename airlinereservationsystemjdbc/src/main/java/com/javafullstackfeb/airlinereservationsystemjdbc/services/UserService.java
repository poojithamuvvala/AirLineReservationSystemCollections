package com.javafullstackfeb.airlinereservationsystemjdbc.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;

public interface UserService {

	public List<FlightsInfo> searchBySource(String source);

	public List<FlightsInfo> searchByName(String flightName);

	public List<FlightsInfo> searchByDestination(String destination);

	public List<FlightsInfo> getAllFlightDetails();

	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo);
}
