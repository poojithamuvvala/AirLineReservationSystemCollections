package com.javafullstackfeb.airlinereservationsystemcollections.airlinecontroller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserService;

import lombok.extern.log4j.Log4j;
@Log4j
public class UserController {
	 public static void userOperations() {
	    	
	 	 Scanner scanner=new Scanner(System.in);
	 	 UserService service1=AirLineFactory.getUserServiceImplInstance();
	    	 try {
					log.info("Enter registered email to login : ");
					String email = scanner.next();
					log.info("Enter registered Password to login : ");
					String password = scanner.next();
					try {
						@SuppressWarnings("unused")
						UsersInfo userBean = service1.authenticateUser(email, password);
						log.info("Logged in Successfully");
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
									log.info("Enter the details to book a ticket");
									log.info("Enter User Id : ");
									int userId = scanner.nextInt();
									UsersInfo user = new UsersInfo();
									user.setUserId(userId);
									log.info("Enter Flight Id : ");
									int flightId2 = scanner.nextInt();
									FlightsInfo flight = new FlightsInfo();
									flight.setFlightId(flightId2);
									log.info("Enter No of seats : ");
									int seats = scanner.nextInt();
									int ticketId = (int) (Math.random() * 10000);
									if (ticketId <= 1000) {
										ticketId = ticketId + 1000;
									}
									BookingsInfo bookingStatus = new BookingsInfo();
									bookingStatus.setNoOfSeatsBooked(seats);
									bookingStatus.setBookingId(ticketId);
									bookingStatus.setUserId(userId);
	                             try {
									TicketRequestInfo request = service1.booktTicket(user, flight);
									request.setTicketid(ticketId);
									log.info("Request placed to admin for booking a ticket");
									log.info(String.format("%-10s %-10s %-150s %s ", "TicketId","userId",
											"UserInfo","FlightInfo"));
									log.info(String.format("%-10s %-10s %-150s %s ",request.getTicketid(),
											request.getUserInfo().getUserId(), request.getUserInfo(), request.getFlightInfo()));
	                             } catch (Exception e) {
	                             	log.info(e.getMessage());
									}
									}
	                             catch (Exception e) {
										log.info(e.getMessage());
									}
									break;
								
								case 2:
									try {
										log.info("Enter BookingId");
										int bookingId = scanner.nextInt();
										if (bookingId == 0) {
											log.info("Please Enter the Valid FlightId");
										} else {

											boolean remove = service1.cancelBooking(bookingId);
											if (remove) {
												log.info("The Booking is cancelled of Id = " + bookingId);
											} else {
												log.info("The Booking is not cancelled of Id = " + bookingId);
											}
										}
									} catch (Exception e) {
										log.info(e.getMessage());
									}
									break;
								case 3:
									   SubAirLineController.airLineOperations();
								default:
									break;
								}
							} catch (InputMismatchException e) {
								log.info("Invalid entry please enter either 1 or 2");
								scanner.nextLine();
							}
						} while (true);
						
						
					} catch (Exception e) {
						log.info("Invalid Credentials");
					}
				
				} catch (Exception e) {
					log.info(e.getMessage());
				}
	    	 scanner.close();
}
}
