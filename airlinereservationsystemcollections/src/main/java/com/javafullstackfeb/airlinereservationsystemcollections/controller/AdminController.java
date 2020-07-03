package com.javafullstackfeb.airlinereservationsystemcollections.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminService;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminController {

	public static void adminOperations() {

		int capacity = 0;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
		LocalDate departureDate = null;
		LocalDate arrivalDate = null;
		LocalTime departureTime = null;
		LocalTime arrivalTime = null;
		Scanner scanner = new Scanner(System.in);
		AdminService service1 = AirLineFactory.getAdminServiceImplInstance();
		log.info("********************** WELCOME TO ADMIN LOGIN FORM ********************");
		try {
			log.info("Enter registered email to login : ");
			String email = scanner.next();
			log.info("Enter registered Password to login : ");
			String password = scanner.next();
			try {

				AdminInfo authBean = service1.authenticateAdmin(email, password);
				if (authBean != null) {
					log.info("You have logged in successfully");

					log.info("Now you can perform the following operations:-");
					do {
						try {
							log.info("===========================================================================");
							log.info("PRESS 1, TO ADD FLIGHTS");
							log.info("PRESS 2, TO SEARCH FLIGHT BY SOURCE");
							log.info("PRESS 3, TO  SEARCH FLIGHT BY DESTINATION");
							log.info("PRESS 4, TO SEARCH FLIGHT BY NAME");
							log.info("PRESS 5, TO CANCEL FLIGHT");
							log.info("PRESS 6, TO VIEW ALL FLIGHTS AND ITS DETAILS");
							log.info("PRESS 7, TO VIEW ALL BOOKINGS");
							log.info("PRESS 8, TO VIEW ALL USERS");
							log.info("PRESS 9, TO LOGOUT");
							log.info("===========================================================================");
							int choice1 = scanner.nextInt();
							switch (choice1) {
							case 1:
								log.info("********************** ADD FLIGHT ********************");
								try {
									log.info("Enter FlightID to add : ");
									flightId = scanner.nextInt();

									log.info("Enter FlightName : ");
									flightName = scanner.next();

									log.info("Enter Source : ");
									flightSource = scanner.next();

									log.info("Enter Destination : ");
									flightDestination = scanner.next();

									log.info("Enter No.of seat Available in the Flight : ");
									capacity = scanner.nextInt();

									log.info("Enter the departure Time : ");
									departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),
											scanner.nextInt());

									log.info("Enter the Arrival Time : ");
									departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),
											scanner.nextInt());

									log.info("Enter the departure date : ");
									departureDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(),
											scanner.nextInt());

									log.info("Enter the arrival date : ");
									arrivalDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

									FlightsInfo bean1 = new FlightsInfo();
									bean1.setFlightId(flightId);
									bean1.setFlightName(flightName);
									bean1.setSource(flightSource);
									bean1.setDestination(flightDestination);
									bean1.setCapacity(capacity);
									bean1.setArrivalTime(arrivalTime);
									bean1.setDepartureTime(departureTime);
									bean1.setDateOfArrival(arrivalDate);
									bean1.setDateOfDeparture(departureDate);
									boolean check2 = service1.addFlight(bean1);
									try {
										if (check2) {
											log.info("Flight added to repository with id : " + flightId);
										} else {
											log.info("Flight already exist of id = " + flightId);
										}
									} catch (InputMismatchException e) {
										log.info("Input MisMatch Exception");
									} catch (Exception e) {
										log.info(e.getMessage());
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 2:
								log.info("********************** SEARCH FLIGHT BY SOURCE ********************");
								try {
									log.info("Search Flight Details by Source : ");
									String source = scanner.next();
									try {
										List<FlightsInfo> flightSource1 = service1.searchFlightBySource(source);
										log.info(
												"===========================================================================");

										for (FlightsInfo flightBean : flightSource1) {
											if (flightBean != null) {
												log.info(flightBean);
											} else {
												log.info("No Flights are available with this Source");
											}
										}
									} catch (InputMismatchException e) {
										log.info("Input Mismatch Exception");
									} catch (Exception e) {
										log.info(e.getMessage());
									}

								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 3:
								log.info("********************** SEARCH FLIGHT BY DESTINATION ********************");
								try {
									log.info("Search flight by Destination : ");
									String destination = scanner.next();
									try {
										List<FlightsInfo> flightDestination1 = service1
												.searchFlightByDestination(destination);

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
										log.info("Input Mismatch Exception");
									} catch (Exception e) {
										log.info(e.getMessage());
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 4:
								log.info("********************** SEARCH FLIGHT BY NAME ********************");
								try {
									log.info(" SEARCH FLIGHT BY NAME : ");
									String name = scanner.next();
									try {
										List<FlightsInfo> fname = service1.searchFlightByName(name);
										log.info(
												"===========================================================================");

										for (FlightsInfo flightBean : fname) {
											if (flightBean != null) {
												log.info(flightBean);
											} else {
												log.info("No Flights are available with this Flight Name");
											}
										}
									} catch (InputMismatchException e) {
										log.info("InputMismatch exception");
									} catch (Exception e) {
										log.info(e.getMessage());
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 5:
								try {
									log.info("Enter FlightId");
									int flightId3 = scanner.nextInt();
									if (flightId3 == 0) {
										log.info("Please Enter the Valid FlightId");
									} else {

										boolean remove = service1.cancelFlight(flightId3);
										if (remove) {
											log.info("The Flight is removed of Id = " + flightId3);
										} else {
											log.info("The Flight is not removed of Id = " + flightId3);
										}
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;
							case 6:
								log.info("********************** VIEW ALL FLIGHTS ********************");
								try {
									List<FlightsInfo> info = service1.viewAllFlights();
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
							case 7:
								try {
									List<BookingsInfo> info1 = service1.viewAllBookings();
									log.info(
											"===========================================================================");
									for (BookingsInfo bookingBean : info1) {
										if (bookingBean != null) {
											log.info(bookingBean);
										} else {
											log.info("No Bookings are available");
										}
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}

								break;

							case 8:
								try {
									List<UsersInfo> info2 = service1.viewAllUsers();
									log.info(
											"===========================================================================");

									for (UsersInfo userBean : info2) {
										if (userBean != null) {
											log.info(userBean);
										} else {
											log.info("No Bookings are available");
										}
									}
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								break;

							case 9:
								SubAirlineController.airLineOperations();

							default:
								log.info("Invalid Choice");
								break;
							}
						} catch (InputMismatchException e) {
							log.info("Invalid entry please provide only integers");
							scanner.nextLine();
						}
					} while (true);
				}
			} catch (Exception e) {
				log.info("Invalid Credentials");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		scanner.close();
	}
}
