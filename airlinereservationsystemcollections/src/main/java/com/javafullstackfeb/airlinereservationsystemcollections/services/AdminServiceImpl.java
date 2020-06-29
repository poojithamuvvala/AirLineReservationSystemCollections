package com.javafullstackfeb.airlinereservationsystemcollections.services;

import java.util.List;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemcollections.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemcollections.validation.Validation;

public class AdminServiceImpl implements AdminService {

	
		AdminDAO dao = new AdminDAOImpl();
		Validation validation = new Validation();

		public AdminInfo authenticateAdmin(String email, String password) {
			if (validation.validateEmail(email)) {
				if (validation.validatePassword(password)) {
					return dao.authenticateAdmin(email, password);
				}

			}

			return null;

		}

		public boolean registerAdmin(AdminInfo adminInfo) {
			
			if(validation.validateId(adminInfo.getAdminid())) {
				 if(validation.validateName(adminInfo.getAdminName())){
					 if (validation.validateMobile(adminInfo.getPhoneNumber())) {
						if(validation.validateEmail(adminInfo.getEmailId())) {
							if(validation.validatePassword(adminInfo.getPassword())) {
								return dao.registerAdmin(adminInfo);
							} 
						}
					} 
				 } 
				
			} 

			return false;
		}

		public boolean addFlight(FlightsInfo flightInfo) {
			if (validation.validateFlightId(flightInfo.getFlightId())) {
				if(validation.validateName(flightInfo.getFlightName())) {
					if(validation.validateName(flightInfo.getSource())) {
						if(validation.validateName(flightInfo.getDestination())) {
							
						return dao.addFlight(flightInfo);
						}
					}
					
				}
				
			}
			return false;

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

