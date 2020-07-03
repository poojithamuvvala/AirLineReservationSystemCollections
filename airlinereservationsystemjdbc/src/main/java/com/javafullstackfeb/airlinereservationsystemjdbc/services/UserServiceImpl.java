package com.javafullstackfeb.airlinereservationsystemjdbc.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemjdbc.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemjdbc.validation.Validation;

public class UserServiceImpl implements UserService {

	UserDAO dao = AirLineFactory.getUserDAOImplInstance();
	Validation validation = AirLineFactory.getValidationImpl();

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
			return dao.searchFlightByName(flightName);
		} else {
			System.out.println("Invalid Source");
		}
		return null;
	}

	@Override
	public List<FlightsInfo> searchFlightBySourceAndDestination(String source,String destination) {
		if (validation.validateName(destination)) {
			return dao.searchFlightBySourceAndDestination(source,destination);
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
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo) {

		return dao.bookTicket(requestInfo);
	}

	@Override
	public boolean cancelTicket(int bookingId) {
		if (validation.validateFlightId(bookingId)) {
			return dao.cancelTicket(bookingId);
		}
		return false;
	}

}
