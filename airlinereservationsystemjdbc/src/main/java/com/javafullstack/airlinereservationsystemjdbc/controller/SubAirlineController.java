package com.javafullstack.airlinereservationsystemjdbc.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;


import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserServiceImpl;



public class SubAirlineController {
	private static final Logger LOGGER = Logger.getLogger(SubAirlineController.class);

	public static void airLineOperations() {

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
		String role=null;
		int noOfSeatsBooked=0;
	
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				LOGGER.info("********************** WELCOME TO AIRLINE RESERVATION SYSTEM ********************");
				LOGGER.info("PRESS 1, to ENTER INTO ADMIN PAGE");
				LOGGER.info("PRESS 2, to ENTER INTO USER PAGE");
				LOGGER.info("PRESS 3, TO View all flights");
				LOGGER.info("PRESS 4, TO SEARCH flight BY SOURCE");
				LOGGER.info("PRESS 5, TO SEARCH flight BY DESTINATION");
				System.out
						.println("===================================================================================");
				UserService userservice=new UserServiceImpl();
				int i = scanner.nextInt();
				switch (i) {
				case 1:
				
					AdminService service = new AdminServiceImpl();
					do {
						try {
							LOGGER.info(
									"********************** WELCOME TO AIRLINE RESERVATION SYSTEMS ADMIN PAGE********************");
							LOGGER.info("PRESS 1, TO ADMIN REGISTERATION");
							LOGGER.info("PRESS 2, TO ADMIN LOGIN");
							LOGGER.info("PRESS 3, TO EXIT");
							int choice = scanner.nextInt();
							switch (choice) {

							case 1:
								LOGGER.info(
										"********************** WELCOME TO ADMIN REGISTRATION FORM ********************");
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
    								
    								LOGGER.info("Enter Role :");
    								role = scanner.next();

    								UserInfo bean = new UserInfo();
    								bean.setEmailId(checkEmail);
    								bean.setPassword(checkPassword);
    								bean.setId(checkId);
    								bean.setUsername(checkName);
    								bean.setPhoneNumber(checkMobileno);
    								bean.setRole(role);
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
					LOGGER.info(
							"********************** WELCOME TO ADMIN LOGIN FORM ********************");
					try {
					LOGGER.info("Enter registered email to login : ");
					String email = scanner.next();
					LOGGER.info("Enter registered Password to login : ");
					String password = scanner.next();
					try {
						AdminService service1 = new AdminServiceImpl();
						UserInfo authBean = service1.authenticateAdmin(email, password);
						if (authBean != null) {
							LOGGER.info("You have logged in successfully");
							LOGGER.info("Now you can perform the following operations:-");
							do {
								try {
									LOGGER.info(
											"===========================================================================");
									LOGGER.info("PRESS 1, TO ADD FLIGHTS");
									LOGGER.info("PRESS 2, TO CANCEL FLIGHT");
									LOGGER.info("PRESS 3, TO VIEW ALL FLIGHTS AND ITS DETAILS");
									LOGGER.info("PRESS 4, TO VIEW ALL USERS");
									LOGGER.info("PRESS 5, TO LOGOUT");
									LOGGER.info(
											"===========================================================================");
									int choice1 = scanner.nextInt();
									switch (choice1) {
									case 1:
										LOGGER.info(
												"********************** ADD FLIGHT ********************");
                                        try {
										LOGGER.info("Enter FlightID to add : ");
										flightId = scanner.nextInt();

										LOGGER.info("Enter FlightName : ");
										flightName = scanner.next();

										LOGGER.info("Enter Source : ");
										flightSource = scanner.next();

										LOGGER.info("Enter Destination : ");
										flightDestination = scanner.next();

										LOGGER.info("Enter No.of seats Booked in the Flight : ");
										noOfSeatsBooked = scanner.nextInt();
										
										LOGGER.info("Enter Capacity in the Flight : ");
										capacity = scanner.nextInt();

										LOGGER.info("Enter the departure Time : ");
										departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt());

										LOGGER.info("Enter the Arrival Time : ");
										departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt());

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
										bean1.setNoOfSeatsBooked(noOfSeatsBooked);
									//	boolean check2 = 
												service.addFlight(bean1);
//										try {
//										if (check2) {
//											LOGGER.info("Flight added to repository with id : " + flightId);
//										} else {
//											LOGGER.info("Flight already exist of id = " + flightId);
//										} 
//										} catch (InputMismatchException e) {
//											LOGGER.info("Input MisMatch Exception");
//										} catch (Exception e) {
//											LOGGER.info(e.getMessage());
//										}
                                        } catch (Exception e) {
                                        	LOGGER.info(e.getMessage());
										}
										break;
									
									case 2:
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
									case 3:LOGGER.info(
											"********************** VIEW ALL FLIGHTS ********************");
										try {
										List<FlightsInfo> info = userservice.getAllFlightDetails();
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
									
									case 4:
										try {
										List<UserInfo> info2 = service.viewAllUsers();
										LOGGER.info(
												"===========================================================================");

										for (UserInfo userBean : info2) {
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

									case 5:
										airLineOperations();

									default:
										LOGGER.info("Invalid Choice");
										break;
									}
								} catch (Exception e) {
									LOGGER.info(e.getMessage());
								}
							}while(true);
					} else {
						LOGGER.info("Invalid");
					}
						
					}catch (Exception e) {
						LOGGER.info(e.getMessage());
					}
					}catch (Exception e) {
						LOGGER.info(e.getMessage());
					}
					break;
				}
				
							case3:
								airLineOperations();

						
					}catch (Exception e) {
						LOGGER.info(e.getMessage());
					}
				}while(true);
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

								LOGGER.info("Enter Role :");
								role=scanner.next();
								UserInfo bean1 = new UserInfo();
								bean1.setId(checkId);
								bean1.setUsername(checkName);
								bean1.setPhoneNumber(checkMobileno);
								bean1.setEmailId(checkEmail);
								bean1.setPassword(checkPassword);
								bean1.setRole(role);
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
									UserInfo userBean = service1.authenticateUser(email, password);
									LOGGER.info("Logged in Successfully");
									do {
										try {
											LOGGER.info(
													"===========================================================================");
											
											LOGGER.info("PRESS 1,TO BOOK TICKET");
											LOGGER.info("PRESS 2,TO LOGOUT");
											LOGGER.info(
													"===========================================================================");
											int choice2 = scanner.nextInt();
											switch (choice2) {
											
											case 1:
												try {
												LOGGER.info("Enter the details to book a ticket");
												LOGGER.info("Enter User Id : ");
												int userId = scanner.nextInt();
												UserInfo user = new UserInfo();
												user.setId(userId);
												LOGGER.info("Enter Flight Id : ");
												int flightId2 = scanner.nextInt();
												FlightsInfo flight = new FlightsInfo();
												flight.setFlightId(flightId2);
												LOGGER.info("Enter No of seats : ");
												int seats = scanner.nextInt();
												
                                                try {
												TicketRequestInfo request = service1.bookTicket(user, flight);
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
											case 2:
												airLineOperations();

											default:
												break;
											}
										} catch (InputMismatchException e) {
											LOGGER.info("Invalid entry please provide only integer");
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
							}
							} catch (Exception e) {
							    LOGGER.info(e.getMessage());
							}
					} while(true);
				case 3:
					LOGGER.info(
							"********************** VIEW ALL FLIGHTS ********************");
						try {
						List<FlightsInfo> info = userservice.getAllFlightDetails();
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
						
				case 4:
					UserService service3=new UserServiceImpl();
					LOGGER.info(
							"********************** SEARCH FLIGHT BY SOURCE ********************");
					try {
					LOGGER.info("Search Flight Details by Source : ");
					String source = scanner.next();
					try {
					List<FlightsInfo> flightSource1 = service3.searchBySource(source);
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

				case 5:
					
					LOGGER.info(
							"********************** SEARCH FLIGHT BY DESTINATION ********************");
					try {
					LOGGER.info("Search flight by Destination : ");
					String destination = scanner.next();
					try {
					List<FlightsInfo> flightDestination1 = userservice.searchByDestination(destination);
							
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
				
				}
	} catch (InputMismatchException e) {
		LOGGER.info(e.getMessage());
	}  catch (Exception e) {
		LOGGER.info(e.getMessage());
	} 
			
}while(true);
	}
}
							

							
				