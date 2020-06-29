package com.javafullstackfeb.airlinereservationsystemjdbc.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UsersInfo;

public interface UserService {
	
	public boolean registerUser(UsersInfo usersInfo);

	public List<FlightsInfo> searchBySource(String source);

	public List<FlightsInfo> searchByName(String flightName);

	public List<FlightsInfo> searchByDestination(String destination);

	public List<FlightsInfo> getAllFlightDetails();

	public UsersInfo authenticateUser(String email, String password);

	public TicketRequestInfo booktTicket(UsersInfo usersInfo, FlightsInfo flightsInfo);
	
	public boolean updateUserInfo(UsersInfo usersInfo);
}
