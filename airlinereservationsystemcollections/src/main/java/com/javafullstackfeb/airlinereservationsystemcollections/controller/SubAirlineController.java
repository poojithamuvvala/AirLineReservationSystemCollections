package com.javafullstackfeb.airlinereservationsystemcollections.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.repository.AirLineDataBase;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserService;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserServiceImpl;

import lombok.extern.log4j.Log4j;
@Log4j
public class SubAirlineController {


	public static void airLineOperations() {

		AirLineDataBase.defaultDatabase();
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
				log.info("********************** WELCOME TO AIRLINE RESERVATION SYSTEM ********************");
				log.info("PRESS 1, to ENTER INTO ADMIN PAGE");
				log.info("PRESS 2, to ENTER INTO USER PAGE");
				System.out
						.println("===================================================================================");
				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminService service = new AdminServiceImpl();
					do {
						try {
							log.info(
									"********************** WELCOME TO AIRLINE RESERVATION SYSTEMS ADMIN PAGE********************");
							log.info("PRESS 1, TO ADMIN REGISTERATION");
							log.info("PRESS 2, TO ADMIN LOGIN");
							log.info("PRESS 3, TO EXIT");
							
							int choice = scanner.nextInt();
							switch (choice) {

							case 1:
								log.info(
										"********************** WELCOME TO ADMIN REGISTRATION FORM ********************");
                                try {
                                	log.info("Enter ID to Register as ADMIN : ");
    								checkId = scanner.nextInt();

    								log.info("Enter Name to Register : ");
    								checkName = scanner.next();

    								log.info("Enter MobileNumber to Register : ");
    								checkMobileno = scanner.next();

    								log.info("Enter Email to Register : ");
    								checkEmail = scanner.next();

    								log.info("Enter Password :");
    								checkPassword = scanner.next();

    								AdminInfo bean = new AdminInfo();
    								bean.setEmailId(checkEmail);
    								bean.setPassword(checkPassword);
    								bean.setAdminid(checkId);
    								bean.setAdminName(checkName);
    								bean.setPhoneNumber(checkMobileno);
    								bean.setRole("admin");
    								try {
    									boolean check = service.registerAdmin(bean);
    									if (check) {
    										log.info("You have registered Successfully");
    									} else {
    										log.info("Already registered");
    									}

    								}catch (Exception e) {
										log.info(e.getMessage());
									}
                                }catch (InputMismatchException e) {
									log.info("Input MisMatch Exception");
								} catch (Exception e) {
									log.info(e.getMessage());
								}
								
								break;

							case 2:
								AdminController.adminOperations();
								break;
							case 3:
								airLineOperations();
								break;

							default:
								log.info("Invalid Choice");
								break;
							}

						} catch (InputMismatchException e) {
							log.info("Invalid entry please provide only  Integer");
							scanner.nextLine();
						} catch (Exception e) {
							log.info(e.getMessage());
							scanner.nextLine();
						}
					} while (true);
				case 2:
					UserService service1 = new UserServiceImpl();
					do {
						try {
							log.info("===========================================================================");
							log.info("PRESS 1,To USER REGISTER");
							log.info("PRESS 2,TO USER LOGIN");
							log.info("PRESS 3,TO EXIT");
							log.info("===========================================================================");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
                                try {
								log.info("Enter ID to Register as USER : ");
								checkId = scanner.nextInt();

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
								boolean check = service1.registerUser(bean1);
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
								break;

							case 2:
								UserController.userOperations();
								break;
							case 3:
								airLineOperations();
								break;

							default:
								log.info("Invalid Choice, Enter either 1 or 2 or 3");

								break;
							}
						} catch (InputMismatchException e) {
							log.info("Invalid entry please provide only integer");
							scanner.nextLine();
						}

					} while (true);

				}
			} catch (InputMismatchException e) {
				log.info("Invalid entry please provide only integer");
				scanner.nextLine();
			}
		} while (true);
	}

}
