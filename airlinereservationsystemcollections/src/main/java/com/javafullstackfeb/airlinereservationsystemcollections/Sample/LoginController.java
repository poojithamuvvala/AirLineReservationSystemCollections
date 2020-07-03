package com.javafullstackfeb.airlinereservationsystemcollections.Sample;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstack.airlinereservationsystemcollections.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserService;

import lombok.extern.log4j.Log4j;
@Log4j
public class LoginController {
	
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
		UserService userservice = AirLineFactory.getUserServiceImplInstance();
		log.info("********************** WELCOME TO LOGIN FORM ********************");
		try {
			log.info("Enter registered email to login : ");
			String email = scanner.next();
			log.info("Enter registered Password to login : ");
			String password = scanner.next();

			try {

				AdminInfo authBean = adminService.authenticateAdmin(email, password);
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

										UsersInfo bean = new UsersInfo();
										bean.setEmailId(checkEmail);
										bean.setPassword(checkPassword);
										bean.setUserId(checkId);
										bean.setUserName(checkName);
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
											log.error("Id should contains only digits");
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
//											
									if (check2) {
										log.info("Flight added to repository with id : " + flightId);
									} else {
										log.info("Flight already exist of id = " + flightId);
									}

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
												log.info("The Flight is removed of Id = " + flightId3);
											} else {
												log.info("The Flight is not removed of Id = " + flightId3);
											}
										}
									} catch (Exception e) {
										log.info(e.getMessage());
									}
									break;

								case 4:
									try {
										List<UsersInfo> info2 = adminService.viewAllUsers();
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

								case 5:
									SubAirLineController2.airLineOperations();

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
							}
						} while (flag);
					} else if (authBean.getRole().equalsIgnoreCase("user")) {
						log.info("Welcome User");
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
										BookingsInfo bookingStatus = new BookingsInfo();
										bookingStatus.setNoOfSeatsBooked(seats);
                                        try {
										TicketRequestInfo request = userservice.booktTicket(user, flight);
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

								
								case 2:
									SubAirLineController2.airLineOperations();

								default:
									break;
								}
							} catch (InputMismatchException e) {
								log.info("Invalid entry please provide only integer");
								scanner.nextLine();
							}
						} while (true);
					}
				} else {
					log.info("Invalid Credentials");
				}

			} catch (Exception e) {
				log.info(e.getMessage());
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
		scanner.close();
	}
}
