package com.javafullstackfeb.airlinereservationsystemjdbc.services;

import java.util.List;

import com.javafullstack.airlinereservationsystemjdbc.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemjdbc.validation.Validation;

public class UserServiceImpl implements UserService {

	UserDAO dao = AirLineFactory.getUserDAOImplInstance();
    Validation validation=new Validation();
	public boolean registerUser(UsersInfo usersInfo) {
		if(validation.validateId(usersInfo.getUserId())) {
			if(validation.validateName(usersInfo.getUserName())) {
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

	public List<FlightsInfo> searchBySource(String source) {
		if (validation.validateName(source)) {
			return dao.searchBySource(source);
		} else {
			System.out.println("Invalid Source");
		}
		return null;
	}

	public List<FlightsInfo> searchByName(String flightName) {
		if (validation.validateName(flightName)) {
			System.out.println(flightName);
			return dao.searchByName(flightName);
		} else {
			System.out.println("Invalid Name");
		}
		return null;
	}

	public List<FlightsInfo> searchByDestination(String destination) {
		if (validation.validateName(destination)) {
			return dao.searchByDestination(destination);
			} else {
				System.out.println("Invalid Destination");
			}
			
			return null;
		
	}

	public List<FlightsInfo> getAllFlightDetails() {

		return dao.getAllFlightDetails();
	}

	public UsersInfo authenticateUser(String email, String password) {
		if(validation.validateEmail(email)) {
			if(validation.validatePassword(password)){
				return dao.authenticateUser(email, password);
			}
		
	}
	return null;
		
	}

	public TicketRequestInfo booktTicket(UsersInfo usersInfo, FlightsInfo flightsInfo) {

		return dao.booktTicket(usersInfo, flightsInfo);
	}

	public boolean updateUserInfo(UsersInfo usersInfo) {

		return dao.updateUserInfo(usersInfo);
	}

}
