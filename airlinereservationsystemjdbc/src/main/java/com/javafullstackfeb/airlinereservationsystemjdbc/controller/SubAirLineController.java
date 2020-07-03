package com.javafullstackfeb.airlinereservationsystemjdbc.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
public class SubAirLineController {

	public static void airLineOperations() {
		int checkId = 0;
		String checkName = null;
		String checkMobileno = null;
		String checkEmail = null;
		String checkPassword = null;

		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		UserService userservice = AirLineFactory.getUserServiceImplInstance();
		AdminService adminService = AirLineFactory.getAdminServiceImplInstance();

		log.info("*****************WELCOME TO AIRLINE RESERVATION SYSTEM********************");

		try {
			List<FlightsInfo> info = userservice.getAllFlightDetails();
			log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId", "flightName",
					"source", "destination", "dateOfDeparture", " dateOfArrival", " arrivalTime", "departureTime",
					" capacity", " noOfSeatsBooked"));
			for (FlightsInfo flightBean : info) {

				if (flightBean != null) {
					log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
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
		do {
			try {
				flag = false;
				log.info("**********AIRLINE RESERVATION SYSTEM OPERATIONS*************");
				log.info("PRESS 1, TO REGISTER AS USER");
				log.info("PRESS 2, TO LOGIN");
				log.info("PRESS 3, TO SEARCH FLIGHT BY SOURCE");
				log.info("PRESS 4, TO SEARCH FLIGHT NAME");
				log.info("PRESS 5, TO SEARCH BY SOURCE AND DESTINATION");
				log.info("Enter your input");
				int i = scanner.nextInt();

				switch (i) {

				case 1:
					log.info("********************** WELCOME TO REGISTRATION FORM ********************");
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

						UserInfo bean = new UserInfo();
						bean.setEmailId(checkEmail);
						bean.setPassword(checkPassword);
						bean.setId(checkId);
						bean.setUsername(checkName);
						bean.setPhoneNumber(checkMobileno);
						bean.setRole("user");
						try {
							boolean check = adminService.registerAdmin(bean);
							if (check) {
								log.info("You have registered Successfully");
							} else {
								log.info("Already registered");
							}

						} catch (Exception e) {
							log.info(e.getMessage());
						}
					} catch (InputMismatchException e) {
						log.info("Input MisMatch Exception");
					} catch (Exception e) {
						log.info(e.getMessage());
					}
					airLineOperations();
					break;

				case 2:
					LoginController.login();
					break;
				
				case 3:

					log.info("********************** SEARCH FLIGHT BY SOURCE ********************");
					try {
						log.info(" ENTER THE SOURCE : ");
						String source = scanner.next();
						try {
							List<FlightsInfo> flightSource1 = userservice.searchBySource(source);
							log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId", "flightName",
									"source", "destination", "dateOfDeparture", " dateOfArrival", " arrivalTime", "departureTime",
									" capacity", " noOfSeatsBooked"));

							for (FlightsInfo flightBean : flightSource1) {
								if (flightBean != null) {
									log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
											flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
											flightBean.getDestination(), flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
											flightBean.getArrivalTime(), flightBean.getDepartureTime(), flightBean.getCapacity(),
											flightBean.getNoOfSeatsBooked()));
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
					airLineOperations();
					break;
				case 4:
					log.info("********************** SEARCH FLIGHT BY NAME ********************");
					try {
						log.info("ENTER THE NAME OF FLIGHT : ");
						String name = scanner.next();
						try {
							List<FlightsInfo> flightname1 = userservice.searchByName(name);
							log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId", "flightName",
									"source", "destination", "dateOfDeparture", " dateOfArrival", " arrivalTime", "departureTime",
									" capacity", " noOfSeatsBooked"));

							for (FlightsInfo flightBean : flightname1) {
								if (flightBean != null) {
									log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
											flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
											flightBean.getDestination(), flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
											flightBean.getArrivalTime(), flightBean.getDepartureTime(), flightBean.getCapacity(),
											flightBean.getNoOfSeatsBooked()));
								} else {
									log.info("No Flights are available with this Name");
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
					airLineOperations();
					break;

				case 5:
					log.info("********************** SEARCH FLIGHT BY SOURCE AND DESTINATION ********************");
					try {
						log.info("ENTER THE SOURCE : ");
						String source = scanner.next();

						log.info("ENTER THE DESTINATION : ");
						String destination = scanner.next();

						try {
							List<FlightsInfo> flightname1 = userservice.searchFlightBySourceAndDestination(source,
									destination);
							log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s", "flightId", "flightName",
									"source", "destination", "dateOfDeparture", " dateOfArrival", " arrivalTime", "departureTime",
									" capacity", " noOfSeatsBooked"));

							for (FlightsInfo flightBean : flightname1) {
								if (flightBean != null) {
									log.info(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %s",
											flightBean.getFlightId(), flightBean.getFlightName(), flightBean.getSource(),
											flightBean.getDestination(), flightBean.getDateOfDeparture(), flightBean.getDateOfArrival(),
											flightBean.getArrivalTime(), flightBean.getDepartureTime(), flightBean.getCapacity(),
											flightBean.getNoOfSeatsBooked()));
								} else {
									log.info("No Flights are available with this source and destination");
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
					airLineOperations();
					break;

				default:
					log.info("Invalid choice, Please Enter only Integers between 1 to 5");
					airLineOperations();
				}

			} catch (InputMismatchException e) {
				log.info("Invalid choice, Please Enter only Integers between 1 to 5");
				airLineOperations();
			} catch (Exception e) {
				log.info(e.getMessage());
			}

		} while (flag);
		scanner.close();
	}

}
