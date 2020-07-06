package com.capgemini.airlinereservationsystem.config;

import org.springframework.context.annotation.Configuration;

import com.javafullstackfeb.airlinereservationsystem.dao.FlightDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.FlightDAOImpl;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAOImpl;

@Configuration
public class AirlineConfigTest {
	
	//@Bean("FlightDAO")
	public FlightDAO getFlightDAO() {
		
		return new FlightDAOImpl();
		
	}
	
	public UserDAO registerUser() {
		return new UserDAOImpl();
	}

}
