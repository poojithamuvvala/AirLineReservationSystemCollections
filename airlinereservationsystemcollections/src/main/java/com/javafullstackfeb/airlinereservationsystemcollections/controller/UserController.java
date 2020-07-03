package com.javafullstackfeb.airlinereservationsystemcollections.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
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
							log.info("PRESS 1,TO SEARCH FLIGHT BY SOURCE");
							log.info("PRESS 2,TO SEARCH FLIGHT BY DESTINATION");
							log.info("PRESS 3,TO SEARCH FLIGHT BY NAME");
							log.info("PRESS 4,TO VIEW ALL FLIGHTDETAILS");
							log.info("PRESS 5,TO BOOK TICKET");
							log.info("PRESS 6,TO LOGOUT");
							log.info(
									"===========================================================================");
							int choice2 = scanner.nextInt();
							switch (choice2) {
							case 1:
								try {
								log.info("Search Flight Details by Source : ");
								String source = scanner.next();
                             try {
                             	List<FlightsInfo> flightSource1 = service1.searchBySource(source);
									log.info(
											"===========================================================================");
									for (FlightsInfo flightBean : flightSource1) {
										if (flightBean != null) {
											log.info(flightBean);
										} else {
											log.info("No Flights are available with this Source");
										}
									}
                             } 
								catch (InputMismatchException e) {
									log.info("Input mismatch exception");
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;

							case 2:
                             try {
								log.info("Search flight by Destination : ");
								String destination = scanner.next();
                             try {
								List<FlightsInfo> flightDestination1 = service1.searchByDestination(destination);
										
								log.info(
										"===========================================================================");
								for (FlightsInfo flightBean : flightDestination1) {
									if (flightBean != null) {
										log.info(flightBean);
									} else {
										log.info("No Flights are available with this Destination");
									}
								}
                             } catch (InputMismatchException e) {
                             	log.info("InputMismatchException");
								} catch (Exception e) {
									log.info(e.getMessage());
								}
                             } catch (Exception e) {
                             	log.info(e.getMessage());
								}
								break;
							case 3:
								try {
								log.info(" SEARCH FLIGHT BY NAME : ");
								String name = scanner.next();

								List<FlightsInfo> fname = service1.searchByName(name);

								for (FlightsInfo flightBean : fname) {
									if (fname != null) {
										log.info(flightBean);
									} else {
										log.info("No Flights are available with this Flight Name");
									}
								}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 4:
								try {
								List<FlightsInfo> info = service1.getAllFlightDetails();
								log.info(
										"===========================================================================");

								for (FlightsInfo flightBean : info) {
									if (flightBean != null) {
										log.info(flightBean);
									} else {
										log.info("No Flight are available in the Flight Details");
									}
								}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 5:
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
								BookingsInfo bookingStatus = new BookingsInfo();
								bookingStatus.setNoOfSeatsBooked(seats);
                             try {
								TicketRequestInfo request = service1.booktTicket(user, flight);
								log.info("Request placed to admin for booking a ticket");
								log.info(
										"<--------------------------------------------------------------------->");

								log.info(request);
                             } catch (Exception e) {
                             	log.info(e.getMessage());
								}
								}
                             catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 6:
								SubAirlineController.airLineOperations();

							default:
								break;
							}
						} catch (InputMismatchException e) {
							log.info("Invalid entry please provide only integer");
							scanner.nextLine();
						}
					} while (true);
				} catch (Exception e) {
					log.info("Invalid Credentials");
				}
				} catch (Exception e) {
					log.info(e.getMessage());
				}
				
     }
}
