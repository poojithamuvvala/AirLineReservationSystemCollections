package com.javafullstackfeb.airlinereservationsystemhibernate.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAOImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.Validation;

public class UserServiceImpl implements UserService {

	UserDAO dao=new  UserDAOImpl();
	Validation validation=new Validation();
	@Override
	public boolean registerUser(UserInfo usersInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FlightsInfo> searchBySource(String source) {
		if (validation.validateName(source)) {
			return dao.searchFlightBySource(source);
		} else {
			System.out.println("Invalid Source");
		}
		return null;
	}

	@Override
	public List<FlightsInfo> searchByName(String flightName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightsInfo> searchByDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightsInfo> getAllFlightDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketRequestInfo bookTicket(UserInfo usersInfo, FlightsInfo flightsInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
