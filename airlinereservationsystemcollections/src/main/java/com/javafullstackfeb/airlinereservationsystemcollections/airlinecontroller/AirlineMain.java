package com.javafullstackfeb.airlinereservationsystemcollections.airlinecontroller;

import com.javafullstackfeb.airlinereservationsystemcollections.repository.AirLineDataBase;

public class AirlineMain {
           public static void main(String[] args) {
        	   AirLineDataBase.defaultDatabase(); 
			SubAirLineController.airLineOperations();
		}
}
