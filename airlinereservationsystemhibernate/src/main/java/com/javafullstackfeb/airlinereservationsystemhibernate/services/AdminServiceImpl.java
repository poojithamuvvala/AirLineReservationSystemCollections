package com.javafullstackfeb.airlinereservationsystemhibernate.services;

import java.util.List;

import com.javafullstack.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemhibernate.validation.Validation;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao = AirLineFactory.getAdminDAOimplInstance();
	Validation validation = new Validation();

	public UserInfo authenticateAdmin(String email, String password) {
		if (validation.validateEmail(email)) {
			if (validation.validatePassword(password)) {
				return dao.authenticateAdmin(email, password);
			}

		}

		return null;

	}

	public boolean registerAdmin(UserInfo adminInfo) {

		if (validation.validateId(adminInfo.getId())) {
			if (validation.validateName(adminInfo.getUsername())) {
				if (validation.validateMobile(adminInfo.getPhoneNumber())) {
					if (validation.validateEmail(adminInfo.getEmailId())) {
						if (validation.validatePassword(adminInfo.getPassword())) {
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
			if (validation.validateName(flightInfo.getFlightName())) {
				if (validation.validateName(flightInfo.getSource())) {
					if (validation.validateName(flightInfo.getDestination())) {

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

	@Override
	public List<UserInfo> viewAllUsers() {
		return dao.viewAllUsers();
	}

	
	

	
}
