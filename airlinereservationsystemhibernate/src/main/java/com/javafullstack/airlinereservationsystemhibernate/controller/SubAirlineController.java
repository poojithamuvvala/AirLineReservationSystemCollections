package com.javafullstack.airlinereservationsystemhibernate.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.javafullstack.airlinereservationsystemhibernate.factory.AirLineFactory;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.UserService;



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
		Scanner scanner=new Scanner(System.in);
		boolean flag=false;
	      do {
	    	  try {
	    		  flag=false;
					LOGGER.info("********************** WELCOME TO AIRLINE RESERVATION SYSTEM ********************");
	    	        LOGGER.info("PRESS 1, TO REGISTER");
	    	        LOGGER.info("PRESS 2, TO LOGIN");
	    	        LOGGER.info("PRESS 3, TO VIEW ALL FLIGHT DETAILS");
	    	        LOGGER.info("PRESS 4, TO SEARCH FLIGHT BY SOURCE");
	    	        LOGGER.info("PRESS 5, TO SEARCH FLIGHT BY SOURCE AND DESTINATION");
	    	        LOGGER.info("Enter your input");
	    	        int i=scanner.nextInt();
	    	     
	    	        UserService userservice =AirLineFactory.getUserServiceImplInstance();
	    	        AdminService adminService=AirLineFactory.getAdminServiceImplInstance();
	    	        switch (i) {
	    	      
	    	        case 1:
	    	        	LOGGER.info(
								"********************** WELCOME TO REGISTRATION FORM ********************");
                        try {
                        	LOGGER.info("Enter ID to Register : ");
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
								boolean check = userservice.registerUser(bean);
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
	    	        	LOGGER.info("********************** WELCOME TO LOGIN FORM ********************");
	    	        	try {
	    					LOGGER.info("Enter registered email to login : ");
	    					String email = scanner.next();
	    					LOGGER.info("Enter registered Password to login : ");
	    					String password = scanner.next();
	    					
	    					
	    					try {
	    						
	    						UserInfo authBean = adminService.authenticateAdmin(email, password);
	    						if (authBean != null) {
	    							LOGGER.info("You have logged in successfully");
	    							LOGGER.info("Now you can perform the following operations:-");
	    							if(authBean.getRole().equalsIgnoreCase("admin")) {
	    								LOGGER.info("Welcome Admin");
	    								do {
	    									try {
	    										LOGGER.info(
	    												"===========================================================================");
	    										LOGGER.info("PRESS 1, TO ADD FLIGHTS");
	    										LOGGER.info("PRESS 2, TO CANCEL FLIGHT");
	    										LOGGER.info("PRESS 3, TO VIEW ALL USERS");
	    										LOGGER.info("PRESS 4, TO LOGOUT");
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
	    											departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

	    											LOGGER.info("Enter the Arrival Time : ");
	    											departureTime = LocalTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

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
	    											adminService.addFlight(bean1);
//	    											try {
//	    											if (check2) {
//	    												LOGGER.info("Flight added to repository with id : " + flightId);
//	    											} else {
//	    												LOGGER.info("Flight already exist of id = " + flightId);
//	    											} 
//	    											} catch (InputMismatchException e) {
//	    												LOGGER.info("Input MisMatch Exception");
//	    											} catch (Exception e) {
//	    												LOGGER.info(e.getMessage());
//	    											}
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

	    												boolean remove = adminService.cancelFlight(flightId3);
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
	    										
	    										case 3:
	    											try {
	    											List<UserInfo> info2 = adminService.viewAllUsers();
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

	    										case 4:
	    											airLineOperations();

	    										default:
	    											LOGGER.info("Invalid Choice");
	    											break;
	    										}
	    									} catch (Exception e) {
	    										LOGGER.info(e.getMessage());
	    									}
	    								}while(true);
	    							}
	    							else if(authBean.getRole().equalsIgnoreCase("user")) {
	    								LOGGER.info("Welcome User");
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
													TicketRequestInfo request = userservice.bookTicket(user, flight, seats);
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
	    							}
	    						}
	    						else {
	    							LOGGER.info("Invalid Credentials");
	    						}
	    						
	    						
	    						
	    					} catch (Exception e) {
	    						LOGGER.info(e.getMessage());
							}
	    					
	    	        	} catch (Exception e) {
							LOGGER.info(e.getMessage());
						}
	    	        	break;
	    	        case 3:
	    	        	LOGGER.info(
								"********************** VIEW ALL FLIGHTS ********************");
							try {
							List<FlightsInfo> info = userservice.getAllFlightDetails();	
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
	    	        	
						LOGGER.info(
								"********************** SEARCH FLIGHT BY SOURCE ********************");
						try {
						LOGGER.info("Search Flight Details by Source : ");
						String source = scanner.next();
						try {
						List<FlightsInfo> flightSource1 =userservice.searchBySource(source);
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
	    	        	
	    	        	default:
	    	        		LOGGER.info("Please Provide only Positive Integers");
	    	        		airLineOperations();
	    	        }
	    	        LOGGER.info("Do You Want To Continue");
	    	        String s=scanner.next();
	    	        if(s.equalsIgnoreCase("Y")) {
	    	        	airLineOperations();
	    	        }
	    	        else {
	    	        	LOGGER.info("**********Thank You***********");
	    	        }
					
	    	  } catch (InputMismatchException e) { 
			     LOGGER.info("Invalid choice, Please Enter only Integers between 1 to 5");
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
			}
	    	  
	    	  
	      } while(flag);
	}
}
							

							
				