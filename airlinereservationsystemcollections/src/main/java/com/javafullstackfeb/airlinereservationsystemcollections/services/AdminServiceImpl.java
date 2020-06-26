package com.javafullstackfeb.airlinereservationsystemcollections.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemcollections.validation.Validation;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao=new AdminDAOImpl();
	Validation validation=new Validation();
	public AdminInfo authenticateAdmin(String email, String password) {
		
		return dao.authenticateAdmin(email, password);
	}

	public boolean registerAdmin(AdminInfo adminInfo) {
		
		return dao.registerAdmin(adminInfo);
	}

	public boolean addFlight(FlightsInfo flightInfo) {
		
		return dao.addFlight(flightInfo);
	}

	public boolean cancelFlight(int id) {
		
		return dao.cancelFlight(id);
	}

	public List<FlightsInfo> searchFlightByName(String flightName) {
		
		return dao.searchFlightByName(flightName);
	}

	public List<FlightsInfo> searchFlightBySource(String source) {
		
		return dao.searchFlightBySource(source);
	}

	public List<FlightsInfo> searchFlightByDestination(String destination) {
		
		return dao.searchFlightByDestination(destination);
	}

	public List<FlightsInfo> viewAllFlights() {
		
		return dao.viewAllFlights();
	}

	public List<UsersInfo> viewAllUsers() {
		
		return dao.viewAllUsers();
	}

	public List<BookingsInfo> viewAllBookings() {
		
		return dao.viewAllBookings();
	}

	public boolean RegisterAdmin(AdminInfo adminInfo) {
		
		return dao.registerAdmin(adminInfo);
	}

}
