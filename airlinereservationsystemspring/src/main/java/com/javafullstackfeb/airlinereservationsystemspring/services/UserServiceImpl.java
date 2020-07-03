package com.javafullstackfeb.airlinereservationsystemspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemspring.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemspring.validations.Validation;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;
	@Autowired
	Validation validation;

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
