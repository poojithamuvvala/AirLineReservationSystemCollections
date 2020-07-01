package com.javafullstackfeb.airlinereservationsystemjdbc.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;

public interface UserDAO {

	public List<FlightsInfo> searchFlightByName(String flightName);

	public List<FlightsInfo> searchFlightBySource(String source);

	public List<FlightsInfo> searchFlightByDestination(String destination);


	
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo);
	
	public List<FlightsInfo> getAllFlightDetails();

	

	
	
	
}
