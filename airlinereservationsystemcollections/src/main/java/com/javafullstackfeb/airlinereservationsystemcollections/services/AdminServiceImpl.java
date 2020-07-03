package com.javafullstackfeb.airlinereservationsystemcollections.services;

import java.util.List;
import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemcollections.validation.Validation;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao = AirLineFactory.getAdminDAOimplInstance();
	Validation validation = new Validation();

	public AdminInfo authenticateAdmin(String email, String password) {
		if (validation.validateEmail(email)) {
			if (validation.validatePassword(password)) {
				return dao.authenticateAdmin(email, password);
			}else {
				throw new AirLineReservationSystemException("Invalid password");
			}

		}else {
			throw new AirLineReservationSystemException("Invalid emailId");
		}

		

	}

	public boolean registerAdmin(AdminInfo adminInfo) {

		if (validation.validateId(adminInfo.getAdminid())) {
			if (validation.validateName(adminInfo.getAdminName())) {
				if (validation.validateMobile(adminInfo.getPhoneNumber())) {
					if (validation.validateEmail(adminInfo.getEmailId())) {
						if (validation.validatePassword(adminInfo.getPassword())) {
							return dao.registerAdmin(adminInfo);
						}
						else {
							throw new AirLineReservationSystemException("Invalid Id! Id should exactly contain 3 digits");
						}
						
					} else {
						throw new AirLineReservationSystemException("Invalid Name! Name should have atleast 4 characters or more than 4 characters");
					}
				}else {
					throw new AirLineReservationSystemException("Inalid Mobile Number! Enter a mobile number whose length should be exactly 10 digits and should start with 6,7,8,9 digits only");
				}
			}else {
				throw new AirLineReservationSystemException("Enter proper email such that it should consist of numbers and alphabets and @ symbol");
			}

		}else {
			throw new AirLineReservationSystemException(
					"Password should contain atleast 5 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
		}

	}

	public boolean addFlight(FlightsInfo flightInfo) {
		if (validation.validateFlightId(flightInfo.getFlightId())) {
			if (validation.validateName(flightInfo.getFlightName())) {
				if (validation.validateName(flightInfo.getSource())) {
					if (validation.validateName(flightInfo.getDestination())) {

						return dao.addFlight(flightInfo);
					}
					else {
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
		throw new AirLineReservationSystemException("Invalid Flight Id");

	}

	public List<FlightsInfo> searchFlightByName(String flightName) {
		if (validation.validateName(flightName)) {
			System.out.println(flightName);
			return dao.searchFlightByName(flightName);
		} else {
			System.out.println("Invalid Name");
		}
		return null;
	}

	public List<FlightsInfo> searchFlightBySource(String source) {
		if (validation.validateName(source)) {
			return dao.searchFlightBySource(source);
		} else {
			System.out.println("Invalid Source");
		}

		return null;
	}

	public List<FlightsInfo> searchFlightByDestination(String destination) {
		if (validation.validateName(destination)) {
			return dao.searchFlightByDestination(destination);
		} else {
			System.out.println("Invalid Destination");
		}

		return null;
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

	

}
