package com.javafullstackfeb.airlinereservationsystemjdbc.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserServiceImpl;


public class SubAirlineController {
	private static final Logger LOGGER = Logger.getLogger(SubAirlineController.class);

	public static void airLineOperations() {

		//AirLineDataBase.defaultDatabase();
		int checkId = 0;
		int capacity = 0;
		String checkName = null;
		String checkMobileno = null;
		String checkEmail = null;
		String checkPassword = null;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
		LocalDate departureDate = null;
		LocalDate arrivalDate = null;
		LocalTime departureTime = null;
		LocalTime arrivalTime = null;
	
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				LOGGER.info("********************** WELCOME TO AIRLINE RESERVATION SYSTEM ********************");
				LOGGER.info("PRESS 1, to ENTER INTO ADMIN PAGE");
				LOGGER.info("PRESS 2, to ENTER INTO USER PAGE");
				System.out
						.println("===================================================================================");
				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminService service = new AdminServiceImpl();
					do {
						try {
							LOGGER.info(
									"===================================================================================");
							LOGGER.info("PRESS 1, TO ADMIN REGISTERATION");
							LOGGER.info("PRESS 2, TO ADMIN LOGIN");
							LOGGER.info("PRESS 3, TO EXIT");
							LOGGER.info(
									"========================================================================================");
							int choice = scanner.nextInt();
							switch (choice) {

							case 1:
                                try {
                                	LOGGER.info("Enter ID to Register as ADMIN : ");
    								checkId = scanner.nextInt();

    								LOGGER.info("Enter Name to Register : ");
    								checkName = scanner.next();

    								LOGGER.info("Enter MobileNumber to Register : ");
    								checkMobileno = scanner.next();

    								LOGGER.info("Enter Email to Register : ");
    								checkEmail = scanner.next();

    								LOGGER.info("Enter Password :");
    								checkPassword = scanner.next();

    								AdminInfo bean = new AdminInfo();
    								bean.setEmailId(checkEmail);
    								bean.setPassword(checkPassword);
    								bean.setAdminid(checkId);
    								bean.setAdminName(checkName);
    								bean.setPhoneNumber(checkMobileno);
    								try {
    									boolean check = service.registerAdmin(bean);
    									if (check) {
    										LOGGER.info("You have registered Successfully");
    									} else {
    										LOGGER.info("Already registered");
    									}

    								}catch (Exception e) {
										LOGGER.info(e.getMessage());
									}
                                }catch (InputMismatchException e) {
									LOGGER.info("Input MisMatch Exception");
								} catch (Exception e) {
									LOGGER.info(e.getMessage());
								}
								

								
								break;

							case 2:
								try {
								LOGGER.info("Enter registered email to login : ");
								String email = scanner.next();
								LOGGER.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {

									AdminInfo authBean = service.authenticateAdmin(email, password);
									if (authBean != null) {
										LOGGER.info("You have logged in successfully");
										LOGGER.info("Now you can perform the following operations:-");
										do {
											try {
												LOGGER.info(
														"===========================================================================");
												LOGGER.info("PRESS 1, TO ADD FLIGHTS");
												LOGGER.info("PRESS 2, TO SEARCH FLIGHT BY SOURCE");
												LOGGER.info("PRESS 3, TO  SEARCH FLIGHT BY DESTINATION");
												LOGGER.info("PRESS 4, TO SEARCH FLIGHT BY NAME");
												LOGGER.info("PRESS 5, TO CANCEL FLIGHT");
												LOGGER.info("PRESS 6, TO VIEW ALL FLIGHTS AND ITS DETAILS");
												LOGGER.info("PRESS 7, TO VIEW ALL BOOKINGS");
												LOGGER.info("PRESS 8, TO VIEW ALL USERS");
												LOGGER.info("PRESS 9, TO LOGOUT");
												LOGGER.info(
														"===========================================================================");
												int choice1 = scanner.nextInt();
												switch (choice1) {
												case 1:
                                                    try {
													LOGGER.info("Enter FlightID to add : ");
													flightId = scanner.nextInt();

													LOGGER.info("Enter FlightName : ");
													flightName = scanner.next();

													LOGGER.info("Enter Source : ");
													flightSource = scanner.next();

													LOGGER.info("Enter Destination : ");
													flightDestination = scanner.next();

													LOGGER.info("Enter No.of seat Available in the Flight : ");
													capacity = scanner.nextInt();

													LOGGER.info("Enter the departure Time : ");
													departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),
															scanner.nextInt());

													LOGGER.info("Enter the Arrival Time : ");
													departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(),
															scanner.nextInt());

													LOGGER.info("Enter the departure date : ");
													departureDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(),
															scanner.nextInt());

													LOGGER.info("Enter the arrival date : ");
													arrivalDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(),
															scanner.nextInt());

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
													boolean check2 = service.addFlight(bean1);
													try {
													if (check2) {
														LOGGER.info("Flight added to repository with id : " + flightId);
													} else {
														LOGGER.info("Flight already exist of id = " + flightId);
													} 
													} catch (InputMismatchException e) {
														LOGGER.info("Input MisMatch Exception");
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													}
                                                    } catch (Exception e) {
                                                    	LOGGER.info(e.getMessage());
													}
													break;
												case 2:
													try {
													LOGGER.info("Search Flight Details by Source : ");
													String source = scanner.next();
													try {
													List<FlightsInfo> flightSource1 = service.searchFlightBySource(source);
													LOGGER.info(
															"===========================================================================");

													for (FlightsInfo flightBean : flightSource1) {
														if (flightBean != null) {
															LOGGER.info(flightBean);
														} else {
															LOGGER.info("No Flights are available with this Source");
														}
													}
													} catch (InputMismatchException e) {
														LOGGER.info("Input Mismatch Exception");
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													}
													
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													}
													break;
												case 3:
													try {
													LOGGER.info("Search flight by Destination : ");
													String destination = scanner.next();
													try {
													List<FlightsInfo> flightDestination1 = service.searchFlightByDestination(destination);
															
													LOGGER.info(
															"===========================================================================");
													for (FlightsInfo flightBean : flightDestination1) {
														if (flightBean != null) {
															LOGGER.info(flightBean);
														} else {
															LOGGER.info(
																	"No Flights are available with this Destination");
														}
													}
													} catch (InputMismatchException e) {
														LOGGER.info("Input Mismatch Exception");
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													} 
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													}
													break;
												case 4:
													try {
													LOGGER.info(" SEARCH FLIGHT BY NAME : ");
													String name = scanner.next();
													try {
													List<FlightsInfo> fname = service.searchFlightByName(name);
													LOGGER.info(
															"===========================================================================");

													for (FlightsInfo flightBean : fname) {
														if (flightBean != null) {
															LOGGER.info(flightBean.getDepartureTime());
														} else {
															LOGGER.info(
																	"No Flights are available with this Flight Name");
														}
													}
													} catch (InputMismatchException e) {
														LOGGER.info("InputMismatch exception");
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													}
													} catch (Exception e) {
                                                       LOGGER.info(e.getMessage());
													}
													break;
												case 5:
													try {
													LOGGER.info("Enter FlightId");
													int flightId3 = scanner.nextInt();
													if (flightId3 == 0) {
														LOGGER.info("Please Enter the Valid FlightId");
													} else {

														boolean remove = service.cancelFlight(flightId3);
														if (remove) {
															LOGGER.info(
																	"The Flight is removed of Id = " + flightId3);
														} else {
															LOGGER.info(
																	"The Flight is not removed of Id = " + flightId3);
														}
													}
													} catch (Exception e) {
														 LOGGER.info(e.getMessage());
													}
													break;
												case 6:
													try {
													List<FlightsInfo> info = service.viewAllFlights();
													LOGGER.info(
															"===========================================================================");

													
													for (FlightsInfo flightBean : info) {
														if (flightBean != null) {
															LOGGER.info(flightBean);
														} else {
															LOGGER.info(
																	"No Flight are available in the Flight Details");
														}
													}
													} catch (Exception e) {
														 LOGGER.info(e.getMessage());
													}
													break;
												case 7:
													try {
														List<BookingsInfo> info1 = service.viewAllBookings();
														LOGGER.info(
																"===========================================================================");
														for (BookingsInfo bookingBean : info1) {
															if (bookingBean != null) {
																LOGGER.info(bookingBean);
															} else {
																LOGGER.info("No Bookings are available");
															}
														}
													} catch (Exception e) {
														LOGGER.info(e.getMessage());
													}
													
													break;

												case 8:
													try {
													List<UsersInfo> info2 = service.viewAllUsers();
													LOGGER.info(
															"===========================================================================");

													for (UsersInfo userBean : info2) {
														if (userBean != null) {
															LOGGER.info(userBean);
														} else {
															LOGGER.info("No Bookings are available");
														}
													}
													} catch (Exception e) {
                                                         LOGGER.info(e.getMessage());
													}
													break;

												case 9:
													airLineOperations();

												default:
													LOGGER.info("Invalid Choice");
													break;
												}
											} catch (InputMismatchException e) {
												LOGGER.info("Invalid entry please provide only positive integer555");
												scanner.nextLine();
											}
										} while (true);
									}
								} catch (Exception e) {
									LOGGER.info("Invalid Credentials");
								}
								} catch (Exception e) {
									LOGGER.info(e.getMessage());
								}
								break;
							case 3:
								airLineOperations();
								break;

							default:
								LOGGER.info("Invalid Choice");
								break;
							}

						} catch (InputMismatchException e) {
							LOGGER.info("Invalid entry please provide only positive integer444");
							scanner.nextLine();
						} catch (Exception e) {
							LOGGER.info(e.getMessage());
							scanner.nextLine();
						}
					} while (true);
				case 2:
					UserService service1 = new UserServiceImpl();
					do {
						try {
							LOGGER.info("===========================================================================");
							LOGGER.info("PRESS 1,To USER REGISTER");
							LOGGER.info("PRESS 2,TO USER LOGIN");
							LOGGER.info("PRESS 3,TO EXIT");
							LOGGER.info("===========================================================================");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
                                try {
								LOGGER.info("Enter ID to Register as USER : ");
								checkId = scanner.nextInt();

								LOGGER.info("Enter Name to Register : ");
								checkName = scanner.next();

								LOGGER.info("Enter MobileNumber to Register : ");
								checkMobileno = scanner.next();

								LOGGER.info("Enter Email to Register : ");
								checkEmail = scanner.next();

								LOGGER.info("Enter Password :");
								checkPassword = scanner.next();

								UsersInfo bean1 = new UsersInfo();
								bean1.setUserId(checkId);
								bean1.setUserName(checkName);
								bean1.setPhoneNumber(checkMobileno);
								bean1.setEmailId(checkEmail);
								bean1.setPassword(checkPassword);
                                try {
								boolean check = service1.registerUser(bean1);
								if (check) {
									LOGGER.info("Registered Successfully");
								} else {
									LOGGER.info("Already registered");
								}
                                } catch (InputMismatchException e) {
									LOGGER.info("Input MisMatch Exception");
								} catch (Exception e) {
                                	LOGGER.info(e.getMessage());
								}
                                } catch (Exception e) {
                                	LOGGER.info(e.getMessage());
								}
								break;

							case 2:
								try {
								LOGGER.info("Enter registered email to login : ");
								String email = scanner.next();
								LOGGER.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {
									@SuppressWarnings("unused")
									UsersInfo userBean = service1.authenticateUser(email, password);
									LOGGER.info("Logged in Successfully");
									do {
										try {
											LOGGER.info(
													"===========================================================================");
											LOGGER.info("PRESS 1,TO SEARCH FLIGHT BY SOURCE");
											LOGGER.info("PRESS 2,TO SEARCH FLIGHT BY DESTINATION");
											LOGGER.info("PRESS 3,TO SEARCH FLIGHT BY NAME");
											LOGGER.info("PRESS 4,TO VIEW ALL FLIGHTDETAILS");
											LOGGER.info("PRESS 5,TO BOOK TICKET");
											LOGGER.info("PRESS 6,TO LOGOUT");
											LOGGER.info(
													"===========================================================================");
											int choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:
												try {
												LOGGER.info("Search Flight Details by Source : ");
												String source = scanner.next();
                                                try {
                                                	List<FlightsInfo> flightSource1 = service1.searchBySource(source);
    												LOGGER.info(
    														"===========================================================================");
    												for (FlightsInfo flightBean : flightSource1) {
    													if (flightBean != null) {
    														LOGGER.info(flightBean);
    													} else {
    														LOGGER.info("No Flights are available with this Source");
    													}
    												}
                                                } 
												catch (InputMismatchException e) {
													LOGGER.info("Input mismatch exception");
												} catch (Exception e) {
													LOGGER.info(e.getMessage());
												}
												
												} catch (Exception e) {
													LOGGER.info(e.getMessage());
												}
												break;

											case 2:
                                                try {
												LOGGER.info("Search flight by Destination : ");
												String destination = scanner.next();
                                                try {
												List<FlightsInfo> flightDestination1 = service1.searchByDestination(destination);
														
												LOGGER.info(
														"===========================================================================");
												for (FlightsInfo flightBean : flightDestination1) {
													if (flightBean != null) {
														LOGGER.info(flightBean);
													} else {
														LOGGER.info("No Flights are available with this Destination");
													}
												}
                                                } catch (InputMismatchException e) {
                                                	LOGGER.info("InputMismatchException");
												} catch (Exception e) {
													LOGGER.info(e.getMessage());
												}
                                                } catch (Exception e) {
                                                	LOGGER.info(e.getMessage());
												}
												break;
											case 3:
												try {
												LOGGER.info(" SEARCH FLIGHT BY NAME : ");
												String name = scanner.next();

												List<FlightsInfo> fname = service1.searchByName(name);

												for (FlightsInfo flightBean : fname) {
													if (fname != null) {
														LOGGER.info(flightBean);
													} else {
														LOGGER.info("No Flights are available with this Flight Name");
													}
												}
												} catch (Exception e) {
													LOGGER.info(e.getMessage());
												}
												break;
											case 4:
												try {
												List<FlightsInfo> info = service1.getAllFlightDetails();
												LOGGER.info(
														"===========================================================================");

												for (FlightsInfo flightBean : info) {
													if (flightBean != null) {
														LOGGER.info(flightBean);
													} else {
														LOGGER.info("No Flight are available in the Flight Details");
													}
												}
												} catch (Exception e) {
													LOGGER.info(e.getMessage());
												}
												break;
											case 5:
												try {
												LOGGER.info("Enter the details to book a ticket");
												LOGGER.info("Enter User Id : ");
												int userId = scanner.nextInt();
												UsersInfo user = new UsersInfo();
												user.setUserId(userId);
												LOGGER.info("Enter Flight Id : ");
												int flightId2 = scanner.nextInt();
												FlightsInfo flight = new FlightsInfo();
												flight.setFlightId(flightId2);
												LOGGER.info("Enter No of seats : ");
												int seats = scanner.nextInt();
												BookingsInfo bookingStatus = new BookingsInfo();
												bookingStatus.setNoOfSeatsBooked(seats);
                                                try {
												TicketRequestInfo request = service1.booktTicket(user, flight);
												LOGGER.info("Request placed to admin for booking a ticket");
												LOGGER.info(
														"<--------------------------------------------------------------------->");

												LOGGER.info(request);
                                                } catch (Exception e) {
                                                	LOGGER.info(e.getMessage());
												}
												}
                                                catch (Exception e) {
													LOGGER.info(e.getMessage());
												}
												break;
											case 6:
												airLineOperations();

											default:
												break;
											}
										} catch (InputMismatchException e) {
											LOGGER.info("Invalid entry please provide only positive integer333");
											scanner.nextLine();
										}
									} while (true);
								} catch (Exception e) {
									LOGGER.info("Invalid Credentials");
								}
								} catch (Exception e) {
									LOGGER.info(e.getMessage());
								}
								break;
							case 3:
								airLineOperations();
								break;

							default:
								LOGGER.info("Invalid Choice, Enter either 1 or 2 or 3");

								break;
							}
						} catch (InputMismatchException e) {
							LOGGER.info("Invalid entry please provide only positive integer222");
							scanner.nextLine();
						}

					} while (true);

				}
			} catch (InputMismatchException e) {
				LOGGER.info("Invalid entry please provide only positive integer111");
				scanner.nextLine();
			}
		} while (true);
	}

}
