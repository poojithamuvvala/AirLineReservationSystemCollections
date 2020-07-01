package com.javafullstackfeb.airlinereservationsystemhibernate.services;

import java.util.List;

import com.javafullstack.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.Validation;

public class UserServiceImpl implements UserService {

	UserDAO dao= AirLineFactory.getUserDAOImplInstance();
	Validation validation=new Validation();
	@Override
	public boolean registerUser(UserInfo usersInfo) {
		if(validation.validateId(usersInfo.getId())) {
			if(validation.validateName(usersInfo.getUsername())) {
				if(validation.validateMobile(usersInfo.getPhoneNumber())) {
			       if(validation.validateEmail(usersInfo.getEmailId())) {
				      if(validation.validatePassword(usersInfo.getPassword())) {  
					return dao.registerUser(usersInfo);
				}
			}
		}
	}
	}
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
		if (validation.validateName(flightName)) {
			return dao.searchFlightBySource(flightName);
		} else {
			System.out.println("Invalid Source");
		}
		return null;
	}

	@Override
	public List<FlightsInfo> searchByDestination(String destination) {
		if (validation.validateName(destination)) {
			return dao.searchFlightByDestination(destination);
		} else {
			System.out.println("Invalid Source");
		}
		return null;
	}

	@Override
	public List<FlightsInfo> getAllFlightDetails() {
		
		return dao.getAllFlightDetails();
	}

	@Override
	public UserInfo authenticateUser(String email, String password) {
		if(validation.validateEmail(email)) {
			if(validation.validatePassword(password)){
				return dao.authenticateUser(email, password);
			}
		
	}
	return null;
	}

	@Override
	public TicketRequestInfo bookTicket(UserInfo usersInfo, FlightsInfo flightsInfo, int noOfSeats) {
		// TODO Auto-generated method stub
		return null;
	}

}
