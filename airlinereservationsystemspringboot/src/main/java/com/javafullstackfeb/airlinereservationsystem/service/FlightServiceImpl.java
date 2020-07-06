package com.javafullstackfeb.airlinereservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafullstackfeb.airlinereservationsystem.bean.TicketBookingBean;
import com.javafullstackfeb.airlinereservationsystem.bean.FlightInformationBean;
import com.javafullstackfeb.airlinereservationsystem.dao.TicketBookingDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.FlightDAO;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDAO flightdao;

	@Autowired
	private TicketBookingDAO bookingDao;

	@Override
	public FlightInformationBean getFlight(String flightNumber) {
		return flightdao.getFlight(flightNumber);
	}

	@Override
	public boolean addFlight(FlightInformationBean flightInformation) {
		return flightdao.addFlight(flightInformation);
	}

	@Override
	public boolean updateFlight(FlightInformationBean flightInformation) {
		return flightdao.updateFlight(flightInformation);
	}

	@Override
	public boolean deleteFlight(String flightNumber) {
		return flightdao.deleteFlight(flightNumber);
	}

	@Override
	public List<FlightInformationBean> search(String departureCity, String arrivalCity, String departureDate) {

		return flightdao.search(departureCity, arrivalCity, departureDate);
	}

	@Override
	public List<FlightInformationBean> getAllFlights() {
		return flightdao.getAllFlights();
	}

	@Override
	public TicketBookingBean bookFlight(TicketBookingBean flightBooking) {
		return bookingDao.bookFlight(flightBooking);
	}

	@Override
	public List<TicketBookingBean> getAllBooking(String userId) {
		return bookingDao.getAllBooking(userId);
	}

	@Override
	public boolean deleteBooking(String bookingId) {
		return bookingDao.deleteBooking(bookingId);
	}

	@Override
	public List<FlightInformationBean> searchFlight(String departureCity, String arrivalCity) {
		// TODO Auto-generated method stub
		return flightdao.searchFlight(departureCity, arrivalCity);
	}

	@Override
	public List<TicketBookingBean> getAllFlightBookings() {
		return bookingDao.getAllFlightBookings();
	}

}
