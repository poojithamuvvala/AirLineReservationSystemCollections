package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;

public interface UserDAO {

	public List<FlightsInfo> searchFlightByName(String flightName);

	public List<FlightsInfo> searchFlightBySource(String source);

	public List<FlightsInfo> searchFlightBySourceAndDestination(String source,String destination);

	public boolean registerUser(UserInfo usersInfo);
	
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo);
	
	public List<FlightsInfo> getAllFlightDetails();

	public UserInfo authenticateUser(String email, String password);

	
	public boolean cancelTicket(int id);
	
}
