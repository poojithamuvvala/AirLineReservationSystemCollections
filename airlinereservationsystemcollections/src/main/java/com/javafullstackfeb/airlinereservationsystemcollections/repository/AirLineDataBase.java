package com.javafullstackfeb.airlinereservationsystemcollections.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;

public class AirLineDataBase {
       
	public static final List<AdminInfo> ADMININFO =new ArrayList<AdminInfo>();
	public static final List<BookingsInfo> BOOKINGSINFO=new ArrayList<BookingsInfo>();
	public static final List<FlightsInfo> FLIGHTSINFO=new ArrayList<FlightsInfo>();
	public static final List<TicketRequestInfo> TICKETREQUESTS =new ArrayList<TicketRequestInfo>();
	public static final List<UsersInfo> USERSINFO=new ArrayList<UsersInfo>();
	
	public static void defaultDatabase() {
		
		AdminInfo adminInfo=new AdminInfo();
		adminInfo.setAdminid(1);
		adminInfo.setEmailId("admin1@gmail.com");
		adminInfo.setPassword("Admin@1");
		adminInfo.setPhoneNumber("9618435065");
		ADMININFO.add(adminInfo);
		
		UsersInfo usersInfo1 =new UsersInfo();
		usersInfo1.setUserId(101);
		usersInfo1.setEmailId("pooji1@gmail.com");
		usersInfo1.setUserName("pooji");
		usersInfo1.setPassword("Pooji@123");
		usersInfo1.setDateOfBirth(LocalDate.of(1998, 6, 4));
		usersInfo1.setAddress("Hyderabad");
		usersInfo1.setPhoneNumber("9553726160");
		usersInfo1.setRole("user");
		USERSINFO.add(usersInfo1);
		
		UsersInfo usersInfo2=new UsersInfo();
		usersInfo2.setUserId(102);
		usersInfo2.setEmailId("ammu@gmail.com");
		usersInfo2.setUserName("ammu");
		usersInfo2.setPassword("Ammu@1");
		usersInfo2.setDateOfBirth(LocalDate.of(2001, 11, 1));
		usersInfo2.setAddress("Vizag");
		usersInfo2.setPhoneNumber("6304341432");
		usersInfo2.setRole("user");
		USERSINFO.add(usersInfo2);
		
		UsersInfo usersInfo3=new UsersInfo();
		usersInfo3.setUserId(103); 
		usersInfo3.setEmailId("suji@gmail.com");
		usersInfo3.setUserName("suji");
		usersInfo3.setPassword("Suji@1");
		usersInfo3.setDateOfBirth(LocalDate.of(1995, 1, 24));
		usersInfo3.setAddress("Banglore");
		usersInfo3.setPhoneNumber("8919305263");
		usersInfo3.setRole("user");
		USERSINFO.add(usersInfo3);
		
		UsersInfo usersInfo4=new UsersInfo();
		usersInfo4.setUserId(104);
		usersInfo4.setEmailId("kushal@gmail.com");
		usersInfo4.setUserName("kushal");
		usersInfo4.setPassword("Kush@1");
		usersInfo4.setDateOfBirth(LocalDate.of(1994, 6, 14));
		usersInfo4.setAddress("Vizaywada");
		usersInfo4.setPhoneNumber("7075331919");
		usersInfo4.setRole("user");
		USERSINFO.add(usersInfo4);
		
		
		UsersInfo usersInfo5=new UsersInfo();
		usersInfo5.setUserId(105);
		usersInfo5.setEmailId("kiran@gmail.com");
		usersInfo5.setUserName("kiran");
		usersInfo5.setPassword("Kiran@1");
		usersInfo5.setDateOfBirth(LocalDate.of(1997, 11, 18));
		usersInfo5.setAddress("Karimnagar");
		usersInfo5.setPhoneNumber("9059848762");	
		usersInfo5.setRole("user");
		USERSINFO.add(usersInfo5);
		
		UsersInfo usersInfo6=new UsersInfo();
		usersInfo6.setUserId(106);
		usersInfo6.setEmailId("lucky@gmail.com");
		usersInfo6.setUserName("lucky");
		usersInfo6.setPassword("Lucky@1");
		usersInfo6.setDateOfBirth(LocalDate.of(2000, 4, 13));
		usersInfo6.setAddress("Chennai");
		usersInfo6.setPhoneNumber("9491680796");
		usersInfo6.setRole("user");
		USERSINFO.add(usersInfo6);
		
		UsersInfo usersInfo7=new UsersInfo();
		usersInfo7.setUserId(107);
		usersInfo7.setEmailId("vital@gmail.com");
		usersInfo7.setUserName("vital");
		usersInfo7.setPassword("Vita@1");
		usersInfo7.setDateOfBirth(LocalDate.of(1990, 8, 12));
		usersInfo7.setAddress("Mumbai");
		usersInfo7.setPhoneNumber("9295452346");
		usersInfo7.setRole("user");
		USERSINFO.add(usersInfo7);
		
	
		BookingsInfo bookingsInfo1=new BookingsInfo();
		bookingsInfo1.setBookingId(1001);
		bookingsInfo1.setUserId(101);
		bookingsInfo1.setFlightId(2001);
		bookingsInfo1.setFlightName("Indigo");
		bookingsInfo1.setNoOfSeatsBooked(3);
		bookingsInfo1.setSeatNos("23,24,25");
		bookingsInfo1.setDateOfBooking(LocalDate.of(2020, 01, 12));
		bookingsInfo1.setDateOfJourney(LocalDate.of(2020, 02, 01));
		bookingsInfo1.setArrivalTime(LocalTime.of(12, 30, 00));
		bookingsInfo1.setDepartureTime(LocalTime.of(3, 30, 00));
		bookingsInfo1.setSource("Vizag");
		bookingsInfo1.setDestination("Hyderabad");
		BOOKINGSINFO.add(bookingsInfo1);
		
		BookingsInfo bookingsInfo2=new BookingsInfo();
		bookingsInfo2.setBookingId(1002);
		bookingsInfo2.setUserId(102);
		bookingsInfo2.setFlightId(2001);
		bookingsInfo2.setFlightName("Indigo");
		bookingsInfo2.setNoOfSeatsBooked(1);
		bookingsInfo2.setSeatNos("21");
		bookingsInfo2.setDateOfBooking(LocalDate.of(2020, 01, 12));
		bookingsInfo2.setDateOfJourney(LocalDate.of(2020, 02, 01));
		bookingsInfo2.setArrivalTime(LocalTime.of(12, 30, 00));
		bookingsInfo2.setDepartureTime(LocalTime.of(3, 30, 00));
		bookingsInfo2.setSource("Vizag");
		bookingsInfo2.setDestination("Hyderabad");
		BOOKINGSINFO.add(bookingsInfo2);
		
		BookingsInfo bookingsInfo3=new BookingsInfo();
		bookingsInfo3.setBookingId(1003);
		bookingsInfo3.setUserId(102);
		bookingsInfo3.setFlightId(2021);
		bookingsInfo3.setFlightName("SpiceJet");
		bookingsInfo3.setNoOfSeatsBooked(3);
		bookingsInfo3.setSeatNos("23,24,25");
		bookingsInfo3.setDateOfBooking(LocalDate.of(2020, 01, 1));
		bookingsInfo3.setDateOfJourney(LocalDate.of(2020, 01, 05));
		bookingsInfo3.setArrivalTime(LocalTime.of(6, 30, 00));
		bookingsInfo3.setDepartureTime(LocalTime.of(8, 00, 00));
		bookingsInfo3.setSource("Banglore");
		bookingsInfo3.setDestination("Hyderabad");
		BOOKINGSINFO.add(bookingsInfo3);
		
		BookingsInfo bookingsInfo4=new BookingsInfo();
		bookingsInfo4.setBookingId(1004);
		bookingsInfo4.setUserId(104);
		bookingsInfo4.setFlightId(2022);
		bookingsInfo4.setFlightName("Indigo");
		bookingsInfo4.setNoOfSeatsBooked(2);
		bookingsInfo4.setSeatNos("3,4");
		bookingsInfo4.setDateOfBooking(LocalDate.of(2019, 12, 1));
		bookingsInfo4.setDateOfJourney(LocalDate.of(2020, 01, 05));
		bookingsInfo4.setArrivalTime(LocalTime.of(3, 30, 00));
		bookingsInfo4.setDepartureTime(LocalTime.of(8, 30, 00));
		bookingsInfo4.setSource("Chennai");
		bookingsInfo4.setDestination("Hyderabad");
		BOOKINGSINFO.add(bookingsInfo4);
		
		BookingsInfo bookingsInfo5=new BookingsInfo();
		bookingsInfo5.setBookingId(1005);
		bookingsInfo5.setUserId(105);
		bookingsInfo5.setFlightId(2022);
		bookingsInfo5.setFlightName("Indigo");
		bookingsInfo5.setNoOfSeatsBooked(3);
		bookingsInfo5.setSeatNos("23,24,26");
		bookingsInfo5.setDateOfBooking(LocalDate.of(2020, 1, 12));
		bookingsInfo5.setDateOfJourney(LocalDate.of(2020, 01, 05));
		bookingsInfo5.setArrivalTime(LocalTime.of(3, 30, 00));
		bookingsInfo5.setDepartureTime(LocalTime.of(8, 30, 00));
		bookingsInfo5.setSource("Chennai");
		bookingsInfo5.setDestination("Hyderabad");
		BOOKINGSINFO.add(bookingsInfo5);
	

		FlightsInfo flightsInfo1=new FlightsInfo();
		flightsInfo1.setFlightId(2001);
		flightsInfo1.setFlightName("Indigo");
		flightsInfo1.setSource("Vizag");
		flightsInfo1.setDestination("Hyderabad");
		flightsInfo1.setDateOfDeparture(LocalDate.of(2020, 01, 30));
		flightsInfo1.setDateOfArrival(LocalDate.of(2020, 02, 01));
		flightsInfo1.setArrivalTime( LocalTime.of(12, 30, 00));
		flightsInfo1.setDepartureTime(LocalTime.of(3, 30, 00));
		flightsInfo1.setCapacity(200);
		flightsInfo1.setNoOfSeatsBooked(52);
		FLIGHTSINFO.add(flightsInfo1);
		
		FlightsInfo flightsInfo2=new FlightsInfo();
		flightsInfo2.setFlightId(2021);
		flightsInfo2.setFlightName("SpiceJet");
		flightsInfo2.setSource("Banglore");
		flightsInfo2.setDestination("Hyderabad");
		flightsInfo2.setDateOfDeparture(LocalDate.of(2020, 01, 1));
		flightsInfo2.setDateOfArrival(LocalDate.of(2020, 01, 05));
		flightsInfo2.setArrivalTime( LocalTime.of(6, 30, 00));
		flightsInfo2.setDepartureTime(LocalTime.of(8, 00, 00));
		flightsInfo2.setCapacity(150);
		flightsInfo2.setNoOfSeatsBooked(40);
		FLIGHTSINFO.add(flightsInfo2);
		
		FlightsInfo flightsInfo3=new FlightsInfo();
		flightsInfo3.setFlightId(2022);
		flightsInfo3.setFlightName("Indigo");
		flightsInfo3.setSource("Chennai");
		flightsInfo3.setDestination("Hyderabad");
		flightsInfo3.setDateOfDeparture(LocalDate.of(2020, 01, 30));
		flightsInfo3.setDateOfArrival(LocalDate.of(2020, 02, 01));
		flightsInfo3.setArrivalTime( LocalTime.of(3, 30, 00));
		flightsInfo3.setDepartureTime(LocalTime.of(8, 30, 00));
		flightsInfo3.setCapacity(150);
		flightsInfo3.setNoOfSeatsBooked(40);
		FLIGHTSINFO.add(flightsInfo3);
		


		TicketRequestInfo requestInfo1=new TicketRequestInfo();
		requestInfo1.setUserInfo(usersInfo7);
		requestInfo1.setFlightInfo(flightsInfo1);
		requestInfo1.setNoOfSeatsToBeBooked(5);
		TICKETREQUESTS.add(requestInfo1);
		
		TicketRequestInfo requestInfo2=new TicketRequestInfo();
		requestInfo2.setUserInfo(usersInfo6);
		requestInfo2.setFlightInfo(flightsInfo1);
		TICKETREQUESTS.add(requestInfo2);

	}
}
