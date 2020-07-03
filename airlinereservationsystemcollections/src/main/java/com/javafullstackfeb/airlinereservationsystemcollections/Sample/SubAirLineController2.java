package com.javafullstackfeb.airlinereservationsystemcollections.Sample;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAirLineController2 {
	public static void airLineOperations() {
        int checkId = 0;
		String checkName = null;
		String checkMobileno = null;
		String checkEmail = null;
		String checkPassword = null;
		
		
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		UserService userservice = AirLineFactory.getUserServiceImplInstance();
		AdminService adminService=AirLineFactory.getAdminServiceImplInstance();
		
		log.info("*****************WELCOME TO AIRLINE RESERVATION SYSTEM********************");
		
		try {
			List<FlightsInfo> info = userservice.getAllFlightDetails();
			log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId", "flightName",
					"source","destination", "dateOfDeparture", " dateOfArrival", " arrivalTime", "departureTime",
					" capacity", " noOfSeatsBooked"));
			for (FlightsInfo flightBean : info) {
				
				if (flightBean != null) {
					log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", flightBean.getFlightId(), flightBean.getFlightName(),
							flightBean.getSource(), flightBean.getDestination(), flightBean.getDateOfDeparture(),						
							flightBean.getDateOfArrival(), flightBean.getArrivalTime(), flightBean.getDepartureTime(),
							flightBean.getCapacity(), flightBean.getNoOfSeatsBooked()));
				} else {
					log.info("No Flight are available in the Flight Details");
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		do {
			try {
				flag = false;
				log.info("**********AIRLINE RESERVATION SYSTEM OPERATIONS*************");
				log.info("PRESS 1, TO REGISTER");
				log.info("PRESS 2, TO LOGIN");
				log.info("PRESS 3, TO VIEW ALL FLIGHT DETAILS");
				log.info("PRESS 4, TO SEARCH FLIGHT BY SOURCE");
				log.info("PRESS 5, TO SEARCH FLIGHT BY NAME");
				log.info("PRESS 6, TO SEARCH FLIGHT BY SOURCE AND DESTINATION");
				log.info("Enter your input");
				int i = scanner.nextInt();

				
				switch (i) {
				    
				}
				} catch (

						InputMismatchException e) {
							log.info("Invalid choice, Please Enter only Integers between 1 to 5");
							airLineOperations();
						} catch (Exception e) {
							log.info(e.getMessage());
						}

					} while (flag);
					scanner.close();
				
					
				}

}
