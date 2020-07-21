package com.javafullstackfeb.airlinereservationsystemhibernate.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.Validation;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao = AirLineFactory.getAdminDAOimplInstance();
	Validation validation = AirLineFactory.getValidationImpl();

	public UserInfo authenticateAdmin(String email, String password) {
		if (validation.validateEmail(email)) {
			if (validation.validatePassword(password)) {
				return dao.authenticateAdmin(email, password);
			} else {
				throw new AirLineReservationSystemException("Invalid password");
			}

		}else {
			throw new AirLineReservationSystemException("Invalid emailId");
		}

	

	}

	public boolean registerAdmin(UserInfo adminInfo) {

		if (validation.validateId(adminInfo.getId())) {
			if (validation.validateName(adminInfo.getUsername())) {
				if (validation.validateMobile(adminInfo.getPhoneNumber())) {
					if (validation.validateEmail(adminInfo.getEmailId())) {
						if (validation.validatePassword(adminInfo.getPassword())) {
							return dao.registerAdmin(adminInfo);
						}  else {
							throw new AirLineReservationSystemException(
									"Password should contain atleast 5 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
						}
						
					} else {
						throw new AirLineReservationSystemException("Enter proper email such that it should consist of numbers and alphabets and @ symbol");
						
					}
				}else {
					throw new AirLineReservationSystemException("Invalid Mobile Number! Enter a mobile number whose length should be exactly 10 digits and should start with 6,7,8,9 digits only");
				}
			}else {
				throw new AirLineReservationSystemException("Invalid Name! Name should have atleast 4 characters or more than 4 characters");
			}

		}else {
			throw new AirLineReservationSystemException("Invalid Id! Id should exactly contain 3 digits");
		
		}

	}

	public boolean addFlight(FlightsInfo flightInfo) {
		if (validation.validateFlightId(flightInfo.getFlightId())) {
			if (validation.validateName(flightInfo.getFlightName())) {
				if (validation.validateName(flightInfo.getSource())) {
					if (validation.validateName(flightInfo.getDestination())) {
                       
						return dao.addFlight(flightInfo);
					} else {
						throw new AirLineReservationSystemException("Invalid Id! Id should exactly contain 4 digits");
					}
				} else {
					throw new AirLineReservationSystemException("Invalid Name! Name should have atleast 4 characters or more than 4 characters");
				}

			} else {
				throw new AirLineReservationSystemException("Invalid Source Name! Name should have atleast 4 characters or more than 4 characters");
			}

		} else {
			throw new AirLineReservationSystemException("Invalid Destination Name! Name should have atleast 4 characters or more than 4 characters");
		}


	}

	public boolean cancelFlight(int id) {

		if (validation.validateFlightId(id)) {
			return dao.cancelFlight(id);
		}
		else{
			throw new AirLineReservationSystemException("Invalid Flight Id");
		}

	}

	@Override
	public List<UserInfo> viewAllUsers() {
		return dao.viewAllUsers();
	}

	
	

	
}
