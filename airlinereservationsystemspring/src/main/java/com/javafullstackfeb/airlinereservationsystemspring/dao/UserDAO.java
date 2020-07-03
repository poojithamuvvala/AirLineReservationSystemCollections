package com.javafullstackfeb.airlinereservationsystemspring.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;

public interface UserDAO {

	public List<FlightsInfo> searchFlightByName(String flightName);

	public List<FlightsInfo> searchFlightBySource(String source);

	public List<FlightsInfo> searchFlightByDestination(String destination);

	public boolean registerUser(UserInfo usersInfo);
	
	public TicketRequestInfo bookTicket(UserInfo usersInfo, FlightsInfo flightsInfo, int noOfSeats);
	
	public List<FlightsInfo> getAllFlightDetails();

	public UserInfo authenticateUser(String email, String password);

	
	
	
}
