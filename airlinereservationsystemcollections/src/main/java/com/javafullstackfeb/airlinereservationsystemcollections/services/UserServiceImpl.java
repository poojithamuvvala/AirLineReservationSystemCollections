package com.javafullstackfeb.airlinereservationsystemcollections.services;

import java.util.List;

import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemcollections.validation.ValidationImpl;


public class UserServiceImpl implements UserService {

	UserDAO dao = AirLineFactory.getUserDAOImplInstance();
    ValidationImpl validation=new ValidationImpl();
	public boolean registerUser(UsersInfo usersInfo) {
		if(validation.validateId(usersInfo.getUserId())) {
			if(validation.validateName(usersInfo.getUserName())) {
				if(validation.validateMobile(usersInfo.getPhoneNumber())) {
			       if(validation.validateEmail(usersInfo.getEmailId())) {
				      if(validation.validatePassword(usersInfo.getPassword())) {  
					return dao.registerUser(usersInfo);
				      }
					else {
						throw new AirLineReservationSystemException(
								"Password should contain atleast 5 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
						
					}
					
				} else {
					throw new AirLineReservationSystemException("Enter proper email such that it should consist of numbers and alphabets and @ symbol");
					
				}
			}else {
				throw new AirLineReservationSystemException("Inalid Mobile Number! Enter a mobile number whose length should be exactly 10 digits and should start with 6,7,8,9 digits only");
			}
		}else {
			throw new AirLineReservationSystemException("Invalid Name! Name should have atleast 4 characters or more than 4 characters");
		}

	}else {
		throw new AirLineReservationSystemException("Invalid Id! Id should exactly contain 3 digits");
	}
		
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
		
			else {
				throw new AirLineReservationSystemException("Invalid password");
			}

		}else {
			throw new AirLineReservationSystemException("Invalid emailId");
		}
	}

	public TicketRequestInfo booktTicket(UsersInfo usersInfo, FlightsInfo flightsInfo) {

		return dao.booktTicket(usersInfo, flightsInfo);
	}

	@Override
	public boolean cancelBooking(int id) {
		if (validation.validateFlightId(id)) {
			return dao.cancelBooking(id);
		}
		throw new AirLineReservationSystemException("Invalid Booking Id");

	}

	@Override
	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination) {
		if (validation.validateName(source)) {
			if (validation.validateName(destination)) {
				return dao.searchFlightBySourceAndDestination(source, destination);
			}
		}
		return null;
	}

	

}
