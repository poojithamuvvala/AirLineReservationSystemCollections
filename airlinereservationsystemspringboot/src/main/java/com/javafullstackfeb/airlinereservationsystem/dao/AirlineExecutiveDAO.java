package com.javafullstackfeb.airlinereservationsystem.dao;

import com.javafullstackfeb.airlinereservationsystem.bean.AirlineExecutiveBeans;

public interface AirlineExecutiveDAO {

	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber);

}
