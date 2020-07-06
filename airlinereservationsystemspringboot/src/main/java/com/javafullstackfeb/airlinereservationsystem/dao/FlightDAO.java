package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.bean.AirportBeans;
import com.javafullstackfeb.airlinereservationsystem.bean.FlightInformationBean;

public interface FlightDAO {

	public FlightInformationBean getFlight(String flightNumber);

	public boolean addFlight(FlightInformationBean flightInformation);

	public boolean updateFlight(FlightInformationBean flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightInformationBean> search(String departureCity, String arrivalCity, String departureDate);
	
	public List<FlightInformationBean> searchFlight(String departureCity, String arrivalCity);
	
	public List<FlightInformationBean> getAllFlights();
	
	public List<AirportBeans> getAllAirport();
		
	}
