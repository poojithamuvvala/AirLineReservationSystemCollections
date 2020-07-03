package com.javafullstackfeb.airlinereservationsystemspring.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;

public interface UserService {
	public boolean registerUser(UserInfo usersInfo);

	public List<FlightsInfo> searchBySource(String source);

	public List<FlightsInfo> searchByName(String flightName);

	public List<FlightsInfo> searchByDestination(String destination);

	public List<FlightsInfo> getAllFlightDetails();

	public UserInfo authenticateUser(String email, String password);

	public TicketRequestInfo bookTicket(UserInfo usersInfo, FlightsInfo flightsInfo, int noOfSeats);
}
