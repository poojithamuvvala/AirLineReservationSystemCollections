package com.capgemini.airlinereservationsystemcollections.dao;

import java.util.List;

import com.capgemini.airlinereservationsystemcollections.bean.FlightsInfo;
import com.capgemini.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.capgemini.airlinereservationsystemcollections.bean.UsersInfo;

public interface UserDAO {
	
	public boolean registerUser(UsersInfo usersInfo);

	public List<FlightsInfo> searchBySource(String source);

	public List<FlightsInfo> searchByName(String flightName);

	public List<FlightsInfo> searchByDestination(String destination);

	public List<FlightsInfo> getAllFlightDetails();

	public UsersInfo authenticateUser(String email, String password);

	public TicketRequestInfo booktTicket(UsersInfo usersInfo, FlightsInfo flightsInfo);
	
	public boolean updateUserInfo(UsersInfo usersInfo);
}
