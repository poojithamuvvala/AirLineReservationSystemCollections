package com.javafullstackfeb.airlinereservationsystemcollections.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;

public interface AdminService {
	public AdminInfo authenticateAdmin(String email, String password);

	public boolean RegisterAdmin(AdminInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);

	public List<FlightsInfo> searchFlightByName(String flightName);

	public List<FlightsInfo> searchFlightBySource(String source);

	public List<FlightsInfo> searchFlightByDestination(String destination);

	public List<FlightsInfo> viewAllFlights();

	public List<UsersInfo> viewAllUsers();

	public List<BookingsInfo> viewAllBookings();

}
