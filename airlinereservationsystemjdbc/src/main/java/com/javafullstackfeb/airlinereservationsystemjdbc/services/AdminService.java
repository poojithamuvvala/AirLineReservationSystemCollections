package com.javafullstackfeb.airlinereservationsystemjdbc.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UsersInfo;

public interface AdminService {
	public AdminInfo authenticateAdmin(String email, String password);

	public boolean registerAdmin(AdminInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);

	public List<FlightsInfo> searchFlightByName(String flightName);

	public List<FlightsInfo> searchFlightBySource(String source);

	public List<FlightsInfo> searchFlightByDestination(String destination);

	public List<FlightsInfo> viewAllFlights();

	public List<UsersInfo> viewAllUsers();

	public List<BookingsInfo> viewAllBookings();

}
