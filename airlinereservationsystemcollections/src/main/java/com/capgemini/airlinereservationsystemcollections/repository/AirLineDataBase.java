package com.capgemini.airlinereservationsystemcollections.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.airlinereservationsystemcollections.bean.AdminInfo;
import com.capgemini.airlinereservationsystemcollections.bean.BookingsInfo;
import com.capgemini.airlinereservationsystemcollections.bean.FlightsInfo;
import com.capgemini.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.capgemini.airlinereservationsystemcollections.bean.UsersInfo;

public class AirLineDataBase {
       
	public static final List<AdminInfo> ADMININFO =new ArrayList<AdminInfo>();
	public static final List<BookingsInfo> BOOKINGSINFO=new ArrayList<BookingsInfo>();
	public static final List<FlightsInfo> FLIGHTSINFO=new ArrayList<FlightsInfo>();
	public static final List<TicketRequestInfo> TICKETREQUESTS =new ArrayList<TicketRequestInfo>();
	public static final List<UsersInfo> USERSINFO=new ArrayList<UsersInfo>();
	
	public void defaultDatabse() {
		ADMININFO.add(new AdminInfo(1,"admin@gmail.com","admin","9618435065"));
		
		USERSINFO.add(new UsersInfo(101,"pooji@gmail.com","pooji","Pooji@1",LocalDate.of(1998, 6, 4),"Hyderabad","9553726160"));
		USERSINFO.add(new UsersInfo(102,"ammu@gmail.com","ammu","Ammu@1",LocalDate.of(2001, 11, 1),"Vizag","6304341432"));
		USERSINFO.add(new UsersInfo(103,"suji@gmail.com","suji","Suji@1",LocalDate.of(1995, 1, 24),"Banglore", "8919305263"));
		USERSINFO.add(new UsersInfo(104,"kushal@gmail.com","kushal","Kush@1",LocalDate.of(1994, 6, 14),"Vizaywada","7075331919"));
		USERSINFO.add(new UsersInfo(105,"kiran@gmail.com","kiran","Kiran@1",LocalDate.of(1997, 11, 18),"Karimnagar","9059848762"));
	  	USERSINFO.add(new UsersInfo(106,"lucky@gmail.com","lucky","Lucky@1",LocalDate.of(2000, 4, 13),"Chennai","9491680796"));
		USERSINFO.add(new UsersInfo(107,"vital@gmail.com","vital","Vita@1",LocalDate.of(1990, 8, 12),"Mumbai","9295452346"));
	
		
		BOOKINGSINFO.add(new BookingsInfo(1001,101,2001,"Indigo",3,"23,24,25",LocalDate.of(2020, 01, 12),LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00),"Vizag","Hyderabad"));
		BOOKINGSINFO.add(new BookingsInfo(1002,102,2001,"Indigo",1,"21",LocalDate.of(2020, 01, 10),LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00),"Vizag","Hyderabad"));
		BOOKINGSINFO.add(new BookingsInfo(1003,103,2021,"SpiceJet",3,"23,24,25",LocalDate.of(2020, 01, 1),LocalDate.of(2020, 01, 05), LocalTime.of(6, 30, 00),LocalTime.of(8, 00, 00),"Bangore","Hyderabad"));
		BOOKINGSINFO.add(new BookingsInfo(1004,104,2022,"Indigo",2,"3,4",LocalDate.of(2019, 12, 1),LocalDate.of(2020, 01, 05), LocalTime.of(3, 30, 00),LocalTime.of(8, 30, 00),"Chennai","Hyderabad"));
		BOOKINGSINFO.add(new BookingsInfo(1005,105,2022,"Indigo",3,"23,24,26",LocalDate.of(2020, 01, 12),LocalDate.of(2020, 02, 01), LocalTime.of(3, 30, 00),LocalTime.of(8, 30, 00),"Chennai","Hyderabad"));

		FLIGHTSINFO.add(new FlightsInfo(2001, "Indigo", "Vizag", "Hyderabad", LocalDate.of(2020, 01, 30), LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00), 200, 52));
		FLIGHTSINFO.add(new FlightsInfo(2021, "SpiceJet", "Banglore", "Hyderabad", LocalDate.of(2020, 01, 1),LocalDate.of(2020, 01, 05), LocalTime.of(6, 30, 00),LocalTime.of(8, 00, 00), 250, 212));
		FLIGHTSINFO.add(new FlightsInfo(2022, "Indigo", "Chennai","Hyderabad", LocalDate.of(2020, 01, 30),LocalDate.of(2020, 02, 01), LocalTime.of(3, 30, 00),LocalTime.of(8, 30, 00), 150, 40));

		TICKETREQUESTS.add(new TicketRequestInfo(new UsersInfo(107,"vital@gmail.com","vital","Vita@1",LocalDate.of(1990, 8, 12),"Mumbai","9295452346"), 
				                 new FlightsInfo(2001, "Indigo", "Vizag", "Hyderabad", LocalDate.of(2020, 01, 30), LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00), 200, 52), 5));
	    
	    TICKETREQUESTS.add(new TicketRequestInfo(new UsersInfo(106,"lucky@gmail.com","lucky","Lucky@1",LocalDate.of(2000, 4, 13),"Chennai","9491680796"), 
                new FlightsInfo(2001, "Indigo", "Vizag", "Hyderabad", LocalDate.of(2020, 01, 30), LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00), 200, 52), 2));
	}
}