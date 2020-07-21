package com.javafullstackfeb.airlinereservationsystemhibernate.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserSpecificOperations {
	
      public static void userOperations() {
    	
  		Scanner scanner = new Scanner(System.in);
  	
  		
  		UserService userservice = AirLineFactory.getUserServiceImplInstance();
    	  do {
				try {
					log.info(
							"===========================================================================");

					log.info("PRESS 1,TO BOOK TICKET");
					log.info("PRESS 2,TO CANCEL TICKET");
					log.info("PRESS 3,TO LOGOUT");
					log.info(
							"===========================================================================");
					int choice2 = scanner.nextInt();
					switch (choice2) {

					case 1:
						try {
							TicketRequestInfo requestInfo = new TicketRequestInfo();
							log.info("Enter User Id : ");
							int userId2 = scanner.nextInt();
							requestInfo.setUid(userId2);
							log.info("Enter Flight Id : ");
							int flightId2 = scanner.nextInt();
							requestInfo.setFlightid(flightId2);
							log.info("Enter No of seats : ");
							int seats = scanner.nextInt();
							requestInfo.setNoOfSeatsToBeBooked(seats);
							
							int bookingId = (int) (Math.random() * 10000);
							if (bookingId <= 1000) {
								bookingId = bookingId + 1000;
							}
                          log.info(bookingId);
                          requestInfo.setTicketid(bookingId);
							
						
							
							try {
								TicketRequestInfo request = userservice.bookTicket(requestInfo);
								if(request!=null) {
								log.info("Request placed to Airline Management ");
								log.info(
										"<--------------------------------------------------------------------->");
								log.info(String.format("%-10s %-10s %-10s %s", "TicketId", "FlightId",
										"UserID", "NoofSeatBooked"));

								log.info(String.format("%-10s %-10s %-10s %s", request.getTicketid(),
										request.getFlightid(), request.getUid(),
										request.getNoOfSeatsToBeBooked()));
								}
								else {
									log.info("Invalid request");
								}
							} catch (Exception e) {
								log.info("Invalid Request of booking");
								e.printStackTrace();
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry  ");
							scanner.nextLine();
						} catch (Exception e) {
							log.info("Invalid request");
						}
						userOperations();
						break;

					case 2:
						log.info("******CANCEL TICKET******");
						log.info("ENTER BOOKING ID");
						try {
							int ticketId = scanner.nextInt();
							userservice.cancelTicket(ticketId);
							if (ticketId == 0) {
								log.info("Please Enter the Valid FlightId");
							} else {
								TicketRequestInfo requestInfo = new TicketRequestInfo();
								requestInfo.setTicketid(ticketId);
								boolean remove = userservice.cancelTicket(ticketId);
								if (remove) {
									log.info("The Cancel ticket Id = " + ticketId);
								} else {
									log.info("The Ticked Id is not removed = " + ticketId);
								}
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry valid Id");
							scanner.nextLine();
						} catch (AirLineReservationSystemException e) {
							log.info(e.getMessage());
						}
						userOperations();
						break;
					case 3:
						SubAirLineController.airLineOperations();

					default:
						log.info("Invalid entry please only Integer between 1 to 3");
						break;
					}
				} catch (InputMismatchException e) {
					log.info("Invalid entry please provide only integer between 1 to 3");
					scanner.nextLine();
				}
				scanner.close();
			} while (true);
    	  
    	  
      }
}
