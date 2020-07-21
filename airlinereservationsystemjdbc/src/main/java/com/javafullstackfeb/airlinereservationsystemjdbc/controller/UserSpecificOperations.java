package com.javafullstackfeb.airlinereservationsystemjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemjdbc.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserSpecificOperations {
	
	public static void userOperations() {

		Scanner scanner = new Scanner(System.in);
		boolean flag = false;

		UserService userservice = AirLineFactory.getUserServiceImplInstance();
		do {
			try {
				flag = false;
				log.info("****************User Operations******************");

				log.info("PRESS 1,TO BOOK TICKET");
				log.info("PRESS 2,TO CANCEL TICKET");
				log.info("PRESS 3,TO LOGOUT");
				log.info("===========================================================================");
				int choice2 = scanner.nextInt();
				switch (choice2) {

				case 1:
					try {
						log.info("Enter User Id : ");
						int userId2 = scanner.nextInt();
						UserInfo userBean = new UserInfo();
						userBean.setId(userId2);
						log.info("Enter Flight Id : ");
						int flightId2 = scanner.nextInt();
						FlightsInfo flightDetails1 = new FlightsInfo();
						flightDetails1.setFlightId(flightId2);
						log.info("Enter No of seats : ");
						int seats = scanner.nextInt();
						int bookingId = (int) (Math.random() * 10000);
						if (bookingId <= 1000) {
							bookingId = bookingId + 1000;
						}

						TicketRequestInfo requestInfo = new TicketRequestInfo();
						requestInfo.setNoOfSeatsToBeBooked(seats);
						requestInfo.setTicketid(bookingId);
						requestInfo.setUid(userId2);
						requestInfo.setFlightid(flightId2);
						try {
							TicketRequestInfo request = userservice.bookTicket(requestInfo);
							log.info("Request placed to Airline Management ");
							log.info("<--------------------------------------------------------------------->");
							log.info(String.format("%-10s %-10s %-10s %s", "TicketId", "FlightId", "UserID",
									"NoofSeatBooked"));

							log.info(String.format("%-10s %-10s %-10s %s", request.getTicketid(), request.getFlightid(),
									request.getUid(), request.getNoOfSeatsToBeBooked()));
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
					log.info("CANCEL TICKET  ");
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
								log.info("The ticket cancelled with Id = " + ticketId);
							} else {
								log.info("The Ticked not cancelled with Id = " + ticketId);
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
					log.info("Invalid choice, Please Enter only Integers between 1 to 3");
					userOperations();
					break;
				}
			} catch (InputMismatchException e) {
				log.info("Invalid entry please provide only integer between 1 to 3");
				userOperations();
				scanner.nextLine();
			}
		} while (flag);
		scanner.close();
	}
}
