package com.javafullstackfeb.airlinereservationsystemspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemspring.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemspring.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemspring.validations.Validation;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO dao;
	@Autowired
	Validation validation ;

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
