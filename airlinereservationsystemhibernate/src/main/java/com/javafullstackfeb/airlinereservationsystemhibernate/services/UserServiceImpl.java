package com.javafullstackfeb.airlinereservationsystemhibernate.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.ValidationImpl;

public class UserServiceImpl implements UserService {

	UserDAO dao = AirLineFactory.getUserDAOImplInstance();
	ValidationImpl validation = new ValidationImpl();

	@Override
	public boolean registerUser(UserInfo usersInfo) {
		if (validation.validateId(usersInfo.getId())) {
			if (validation.validateName(usersInfo.getUsername())) {
				if (validation.validateMobile(usersInfo.getPhoneNumber())) {
					if (validation.validateEmail(usersInfo.getEmailId())) {
						if (validation.validatePassword(usersInfo.getPassword())) {
							return dao.registerUser(usersInfo);
						} else {
							throw new com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException(
									"Invalid Id! Id should exactly contain 3 digits");
						}

					} else {
						throw new AirLineReservationSystemException(
								"Invalid Name! Name should have atleast 4 characters or more than 4 characters");
					}
				} else {
					throw new AirLineReservationSystemException(
							"Inalid Mobile Number! Enter a mobile number whose length should be exactly 10 digits and should start with 6,7,8,9 digits only");
				}
			} else {
				throw new AirLineReservationSystemException(
						"Enter proper email such that it should consist of numbers and alphabets and @ symbol");
			}

		} else {
			throw new AirLineReservationSystemException(
					"Password should contain atleast 5 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
		}

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
	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination) {
		if (validation.validateName(destination)) {
			return dao.searchFlightBySourceAndDestination(source, destination);
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
		if (validation.validateEmail(email)) {
			if (validation.validatePassword(password)) {
				return dao.authenticateUser(email, password);
			}

		}
		return null;
	}

	@Override
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo) {
		return dao.bookTicket(requestInfo);
	}

	@Override
	public boolean cancelTicket(int bookingId) {
       if(validation.validateFlightId(bookingId)) {
		return dao.cancelTicket(bookingId);
	}
       else{
    	   throw new  AirLineReservationSystemException("Illegal Booking Id"); 
       }
	 
	}

}
