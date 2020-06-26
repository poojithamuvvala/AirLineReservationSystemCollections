package com.javafullstackfeb.airlinereservationsystemcollections.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {

	UserDAO dao = new UserDAOImpl();

	public boolean registerUser(UsersInfo usersInfo) {

		return dao.registerUser(usersInfo);
	}

	public List<FlightsInfo> searchBySource(String source) {

		return dao.searchBySource(source);
	}

	public List<FlightsInfo> searchByName(String flightName) {

		return dao.searchByName(flightName);
	}

	public List<FlightsInfo> searchByDestination(String destination) {

		return dao.searchByDestination(destination);
	}

	public List<FlightsInfo> getAllFlightDetails() {

		return dao.getAllFlightDetails();
	}

	public UsersInfo authenticateUser(String email, String password) {

		return dao.authenticateUser(email, password);
	}

	public TicketRequestInfo booktTicket(UsersInfo usersInfo, FlightsInfo flightsInfo) {

		return dao.booktTicket(usersInfo, flightsInfo);
	}

	public boolean updateUserInfo(UsersInfo usersInfo) {

		return dao.updateUserInfo(usersInfo);
	}

}
