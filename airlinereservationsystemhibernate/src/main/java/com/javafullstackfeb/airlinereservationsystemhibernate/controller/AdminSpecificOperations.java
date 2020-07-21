package com.javafullstackfeb.airlinereservationsystemhibernate.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.AdminService;

import lombok.extern.log4j.Log4j;
@Log4j
public class AdminSpecificOperations {
	
	public static void login() {

		int capacity = 0;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
		LocalDate departureDate = null;
		LocalDate arrivalDate = null;
		LocalTime departureTime = null;
		LocalTime arrivalTime = null;
		int noOfSeatsBooked = 0;
		int checkId = 0;
		String checkName = null;
		String checkMobileno = null;
		String checkEmail = null;
		String checkPassword = null;

		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		AdminService adminService = AirLineFactory.getAdminServiceImplInstance();
		
		log.info("********************** WELCOME TO LOGIN FORM ********************");
		try {
			log.info("Enter registered email to login : ");
			String email = scanner.next();
			log.info("Enter registered Password to login : ");
			String password = scanner.next();

			try {

				UserInfo authBean = adminService.authenticateAdmin(email, password);
				if (authBean != null) {
					log.info("You have logged in successfully");
					log.info("Now you can perform the following operations:-");
					if (authBean.getRole().equalsIgnoreCase("admin")) {
						log.info("Welcome Admin");
						do {
							try {
								flag=false;
								log.info(
										"===========================================================================");
								log.info("PRESS 1, TO REGISTER");
								log.info("PRESS 2, TO ADD FLIGHTS");
								log.info("PRESS 3, TO CANCEL FLIGHT");
								log.info("PRESS 4, TO VIEW ALL USERS");
								log.info("PRESS 5, TO LOGOUT");
								log.info(
										"===========================================================================");
								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									log.info(
											"********************** WELCOME TO ADMIN REGISTRATION FORM ********************");
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
										bean.setRole("admin");
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
									login();
									break;
								case 2:
									log.info("********************** ADD FLIGHT ********************");

									do {

										try {
											log.info("Enter FlightID to add : ");
											flightId = scanner.nextInt();
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("FlightId should contain only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {

										try {
											log.info("Enter FlightName : ");
											flightName = scanner.next();
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("FlightName should contain only alphabets");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {

										try {
											log.info("Enter Source : ");
											flightSource = scanner.next();
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("Source should contain only alphabets");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {

										try {
											log.info("Enter Destination : ");
											flightDestination = scanner.next();
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("Destination should contain only alphabets");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);

									do {

										try {
											log.info("Enter the departure date : ");
											departureDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(),
													scanner.nextInt());
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("date should contain only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {
										try {
											log.info("Enter the arrival date : ");
											arrivalDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(),
													scanner.nextInt());
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("date should contain only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {

										try {
											log.info("Enter the departure Time : ");
											departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),
													scanner.nextInt());
											
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("time should contain only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									do {

										try {
											log.info("Enter the Arrival Time : ");
											arrivalTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),
													scanner.nextInt());
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("time should contain only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);

									do {

										try {
											log.info("Enter Capacity in the Flight : ");
											capacity = scanner.nextInt();
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("Capacity should contains only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);

									do {

										try {
											log.info("Enter No.of seats Booked in the Flight : ");
											noOfSeatsBooked = scanner.nextInt();
										
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											log.error("NoOfSeatsBooked should contain only digits");
											scanner.next();
										} catch (AirLineReservationSystemException e) {
											flag = false;
											log.error(e.getMessage());
										}
									} while (!flag);
									FlightsInfo bean1 = new FlightsInfo();
									bean1.setFlightId(flightId);
									bean1.setFlightName(flightName);
									bean1.setSource(flightSource);
									bean1.setDestination(flightDestination);
									bean1.setDateOfDeparture(departureDate);
									bean1.setDateOfArrival(arrivalDate);
									bean1.setDepartureTime(departureTime);
									bean1.setArrivalTime(arrivalTime);
									bean1.setCapacity(capacity);
									bean1.setNoOfSeatsBooked(noOfSeatsBooked);
									boolean check2 = adminService.addFlight(bean1);
										
									if (check2) {
										log.info("Flight added to repository with id : " + flightId);
									} else {
										log.info("Flight already exist with id = " + flightId);
									}
                                     login();
									break;

								case 3:
									try {
										log.info("Enter FlightId");
										int flightId3 = scanner.nextInt();
										if (flightId3 == 0) {
											log.info("Please Enter the Valid FlightId");
										} else {

											boolean remove = adminService.cancelFlight(flightId3);
											if (remove) {
												log.info("The Flight is removed with Id = " + flightId3);
											} else {
												log.info("The Flight is not removed with Id = " + flightId3);
											}
										}
									} catch (Exception e) {
										log.info(e.getMessage());
									}
								    login();
									break;

								case 4:
									try {
										List<UserInfo> info2 = adminService.viewAllUsers();
										log.info(String.format("%-15s %-15s %-15s %-15s  %s", "Id", "UserName", "EmailId",
												"phoneNumber" , "role"));
										for (UserInfo userBean : info2) {
											if (userBean != null) {
												log.info(String.format("%-15s %-15s %-15s %-15s %s", "Id", userBean.getId(), userBean.getUsername(),
														userBean.getPhoneNumber() , userBean.getRole()));
											} else {
												log.info("No Users are available");
											}
										}
									} catch (Exception e) {
										log.info(e.getMessage());
									}
									login();
									break;

								case 5:
									SubAirLineController.airLineOperations();

								default:
									log.info("Invalid Choice, Please Enter Integers between 1 to 5");
									login();
									break;
								}
							} catch (InputMismatchException e) {
								log.info("Invalid Choice, Please Enter Integers between 1 to 5");
								login();
							}
							catch (Exception e) {
								log.info(e.getMessage());
								login();
							}
						} while (flag);
					} else if (authBean.getRole().equalsIgnoreCase("user")) {
						log.info("Welcome User");
						UserSpecificOperations.userOperations();
					}
				} else {
					log.info("Invalid Credentials");
					login();
				}

			} catch (Exception e) {
				log.info(e.getMessage());
				login();
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
		scanner.close();
	}
}
