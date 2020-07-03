package com.javafullstackfeb.airlinereservationsystemspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightResponse;
import com.javafullstackfeb.airlinereservationsystemspring.exception.AirLineReservationSystemException;

@RestControllerAdvice
public class AirLineControllerAdvice {
	@ExceptionHandler(AirLineReservationSystemException.class)
             public void handleAirlineException(AirLineReservationSystemException exception) {
            	FlightResponse flightResponse=new FlightResponse();
             }
}
