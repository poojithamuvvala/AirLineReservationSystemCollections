package com.javafullstackfeb.airlinereservationsystemspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javafullstackfeb.airlinereservationsystemspring.bean.AirLineResponse;
import com.javafullstackfeb.airlinereservationsystemspring.exception.AirLineReservationSystemException;

@RestControllerAdvice
public class AirLineControllerAdvice {
	@ExceptionHandler(AirLineReservationSystemException.class)
             public AirLineResponse handleAirlineException(AirLineReservationSystemException exception) {
            	AirLineResponse airlineResponse=new AirLineResponse();
            	 airlineResponse.setError(true);
            	 airlineResponse.setMessage(exception.getMessage());
            	 return airlineResponse;
             }
	@ExceptionHandler(Exception.class)
    public AirLineResponse handleException(Exception exception) {
   	AirLineResponse airlineResponse=new AirLineResponse();
   	 airlineResponse.setError(true);
   	 airlineResponse.setMessage(exception.getMessage());
   	 return airlineResponse;
    }
}
