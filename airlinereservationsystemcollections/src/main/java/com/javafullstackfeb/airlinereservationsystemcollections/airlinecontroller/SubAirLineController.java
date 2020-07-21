package com.javafullstackfeb.airlinereservationsystemcollections.airlinecontroller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAirLineController {

	public static void airLineOperations() {
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		int checkId = 0;
		String checkName = null;
		String checkMobileno = null;
		String checkEmail = null;
		String checkPassword = null;
		UserService userService = AirLineFactory.getUserServiceImplInstance();

		log.info("*****************WELCOME TO AIRLINE RESERVATION SYSTEM********************");
		
		do {
			try {
				flag = false;
				log.info("PRESS 1, TO REGISTER AS USER");
				log.info("PRESS 2, TO LOGIN AS USER");
				log.info("PRESS 3, TO LOGIN AS ADMIN");
				log.info("PRESS 4, TO SEARCH FLIGHT BY SOURCE");
				log.info("PRESS 5, TO SEARCH FLIGHT NAME");
				log.info("PRESS 6, TO SEARCH BY  DESTINATION");
				log.info("PRESS 7, TO SEARCH BY SOURCE AND DESTINATION");
				log.info("PRESS 8, TO VIEW ALL FLIGHTS");
				log.info("Enter your input");
				int i = scanner.nextInt();

				switch (i) {
				case 1:
					try {
						checkId = (int) (Math.random() * 1000);
						if (checkId <= 100) {
							checkId = checkId + 100;
						}
						log.info("Enter Name to Register : ");
						checkName = scanner.next();

						log.info("Enter MobileNumber to Register : ");
						checkMobileno = scanner.next();

						log.info("Enter Email to Register : ");
						checkEmail = scanner.next();

						log.info("Enter Password :");
						checkPassword = scanner.next();

						UsersInfo bean1 = new UsersInfo();
						bean1.setUserId(checkId);
						bean1.setUserName(checkName);
						bean1.setPhoneNumber(checkMobileno);
						bean1.setEmailId(checkEmail);
						bean1.setPassword(checkPassword);
						try {
							boolean check = userService.registerUser(bean1);
							if (check) {
								log.info("Registered Successfully");
							} else {
								log.info("Already registered");
							}
						} catch (InputMismatchException e) {
							log.info("Input MisMatch Exception");
						} catch (Exception e) {
							log.info(e.getMessage());
						}
					} catch (Exception e) {
						log.info(e.getMessage());
					}
					UserController.userOperations();
					break;
				case 2:
					UserController.userOperations();
					break;

				case 3:
					AdminController.adminOperations();
					break;
				case 4:
					try {
						log.info("Search Flight Details by Source : ");
						String source = scanner.next();
						try {
							List<FlightsInfo> flightSource1 = userService.searchBySource(source);

							log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
									"flightId", "flightName", "source", "destination", "dateOfDeparture",
									" dateOfArrival", " arrivalTime", "departureTime", " capacity",
									" noOfSeatsBooked"));

							log.info("===========================================================================");
							for (FlightsInfo flightBean : flightSource1) {
								if (flightBean != null) {
									log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
											flightBean.getFlightId(), flightBean.getFlightName(),
											flightBean.getSource(), flightBean.getDestination(),
											flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
											flightBean.getArrivalTime(), flightBean.getDepartureTime(),
											flightBean.getCapacity(), flightBean.getNoOfSeatsBooked()));
								} else {
									log.info("No Flights are available with this Source");

								}
							}
						} catch (InputMismatchException e) {
							log.info("Input mismatch exception");
						} catch (Exception e) {
							log.info(e.getMessage());
							airLineOperations();
						}

					} catch (Exception e) {
						log.info(e.getMessage());
					}
					airLineOperations();
					break;

				case 5:
					try {
						log.info(" SEARCH FLIGHT BY NAME : ");
						String name = scanner.next();

						List<FlightsInfo> fname = userService.searchByName(name);

						log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId",
								"flightName", "source", "destination", "dateOfDeparture", " dateOfArrival",
								" arrivalTime", "departureTime", " capacity", " noOfSeatsBooked"));

						for (FlightsInfo flightBean : fname) {
							if (fname != null) {
								log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
										flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
										flightBean.getDestination(), flightBean.getDateOfDeparture(),
										flightBean.getDateOfArrival(), flightBean.getArrivalTime(),
										flightBean.getDepartureTime(), flightBean.getCapacity(),
										flightBean.getNoOfSeatsBooked()));
							} else {
								log.info("No Flights are available with this Flight Name");
							}
						}
					} catch (Exception e) {
						airLineOperations();
						log.info(e.getMessage());
					}
					airLineOperations();
					break;
				case 6:
					try {
						log.info("Search flight by Destination : ");
						String destination = scanner.next();
						try {
							List<FlightsInfo> flightDestination1 = userService.searchByDestination(destination);

							log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
									"flightId", "flightName", "source", "destination", "dateOfDeparture",
									" dateOfArrival", " arrivalTime", "departureTime", " capacity",
									" noOfSeatsBooked"));

							log.info("===========================================================================");
							for (FlightsInfo flightBean : flightDestination1) {
								if (flightBean != null) {
									log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
											flightBean.getFlightId(), flightBean.getFlightName(),
											flightBean.getSource(), flightBean.getDestination(),
											flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
											flightBean.getArrivalTime(), flightBean.getDepartureTime(),
											flightBean.getCapacity(), flightBean.getNoOfSeatsBooked()));
								} else {
									log.info("No Flights are available with this Destination");
								}
							}
						} catch (InputMismatchException e) {
							log.info("InputMismatchException");
						} catch (Exception e) {
							airLineOperations();
							log.info(e.getMessage());
						}
					} catch (Exception e) {
						log.info(e.getMessage());
					}
					airLineOperations();
					break;

				case 7:
					try {
						log.info("Search flight by Source : ");
						String source = scanner.next();

						log.info("Search flight by Destination : ");
						String destination = scanner.next();
						try {
							List<FlightsInfo> flightDestination1 = userService
									.searchFlightBySourceAndDestination(source, destination);

							log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
									"flightId", "flightName", "source", "destination", "dateOfDeparture",
									" dateOfArrival", " arrivalTime", "departureTime", " capacity",
									" noOfSeatsBooked"));

							log.info("===========================================================================");
							for (FlightsInfo flightBean : flightDestination1) {
								if (flightBean != null) {
									log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
											flightBean.getFlightId(), flightBean.getFlightName(),
											flightBean.getSource(), flightBean.getDestination(),
											flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
											flightBean.getArrivalTime(), flightBean.getDepartureTime(),
											flightBean.getCapacity(), flightBean.getNoOfSeatsBooked()));
								} else {
									log.info("No Flights are available with this Destination");
								}
							}
						} catch (InputMismatchException e) {
							log.info("InputMismatchException");
						} catch (Exception e) {
							airLineOperations();
							log.info(e.getMessage());
						}
					} catch (Exception e) {
						log.info(e.getMessage());
					}
					airLineOperations();
					break;
				case 8:
					try {
						log.info("ALL FLIGHTS AND ITS DETAILS ARE:");
						List<FlightsInfo> info = userService.getAllFlightDetails();
						log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId", "flightName",
								"source", "destination", "dateOfDeparture", "dateOfArrival", " arrivalTime", "departureTime",
								" capacity", " noOfSeatsBooked"));

						for (FlightsInfo flightBean : info) {
							if (flightBean != null) {
								log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-19s %-18s %-15s %s",
										flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
										flightBean.getDestination(), flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
										flightBean.getArrivalTime(), flightBean.getDepartureTime(), flightBean.getCapacity(),
										flightBean.getNoOfSeatsBooked()));
							} else {
								log.info("No Flight are available in the Flight Details");
							}
						}
					} catch (Exception e) {
						
						log.info(e.getMessage());
					}
                    airLineOperations();
                    break;
				default:
					airLineOperations();
					break;
				}
			} catch (InputMismatchException e) {
				log.info("Invalid choice, Please Enter only Integers between 1 to 8");
				airLineOperations();
			} catch (Exception e) {
				log.info(e.getMessage());
			}

		} while (flag);
		scanner.close();
	}
}
