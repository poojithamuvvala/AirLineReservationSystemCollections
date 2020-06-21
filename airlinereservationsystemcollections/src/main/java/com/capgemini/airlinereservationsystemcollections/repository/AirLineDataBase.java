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
       
	private static final List<AdminInfo> ADMININFOS =new ArrayList<AdminInfo>();
	private static final List<BookingsInfo> BOOKINGSINFOS=new ArrayList<BookingsInfo>();
	private static final List<FlightsInfo> FLIGHTSINFOS=new ArrayList<FlightsInfo>();
	private static final List<TicketRequestInfo> TICKETREQUESTINFOS =new ArrayList<TicketRequestInfo>();
	private static final List<UsersInfo> USERSINFOS=new ArrayList<UsersInfo>();
	
	public void defaultDatabse() {
		ADMININFOS.add(new AdminInfo(1,"admin@gmail.com","admin","9618435065"));
		
		USERSINFOS.add(new UsersInfo(101,"pooji@gmail.com","pooji",LocalDate.of(1998, 6, 4),"Hyderabad","9553726160"));
		USERSINFOS.add(new UsersInfo(102,"ammu@gmail.com","ammu",LocalDate.of(2001, 11, 1),"Vizag","6304341432"));
		USERSINFOS.add(new UsersInfo(103,"suji@gmail.com","suji",LocalDate.of(1995, 1, 24),"Banglore", "8919305263"));
		USERSINFOS.add(new UsersInfo(104,"kushal@gmail.com","kushal",LocalDate.of(1994, 6, 14),"Vizaywada","7075331919"));
		USERSINFOS.add(new UsersInfo(105,"kiran@gmail.com","kiran",LocalDate.of(1997, 11, 18),"Karimnagar","9059848762"));
	  	USERSINFOS.add(new UsersInfo(106,"lucky@gmail.com","lucky",LocalDate.of(2000, 4, 13),"Chennai","9491680796"));
		USERSINFOS.add(new UsersInfo(107,"vital@gmail.com","vital",LocalDate.of(1990, 8, 12),"Mumbai","9295452346"));
	
		
		BOOKINGSINFOS.add(new BookingsInfo(1001,101,2001,"Indigo",3,"23,24,25",LocalDate.of(2020, 01, 12),LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00),"Vizag","Hyderabad"));
		BOOKINGSINFOS.add(new BookingsInfo(1002,102,2001,"Indigo",1,"21",LocalDate.of(2020, 01, 10),LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00),"Vizag","Hyderabad"));
		BOOKINGSINFOS.add(new BookingsInfo(1003,103,2021,"SpiceJet",3,"23,24,25",LocalDate.of(2020, 01, 1),LocalDate.of(2020, 01, 05), LocalTime.of(6, 30, 00),LocalTime.of(8, 00, 00),"Bangore","Hyderabad"));
		BOOKINGSINFOS.add(new BookingsInfo(1004,104,2022,"Indigo",2,"3,4",LocalDate.of(2019, 12, 1),LocalDate.of(2020, 01, 05), LocalTime.of(3, 30, 00),LocalTime.of(8, 30, 00),"Chennai","Hyderabad"));
		BOOKINGSINFOS.add(new BookingsInfo(1005,105,2022,"Indigo",3,"23,24,26",LocalDate.of(2020, 01, 12),LocalDate.of(2020, 02, 01), LocalTime.of(3, 30, 00),LocalTime.of(8, 30, 00),"Chennai","Hyderabad"));

		FLIGHTSINFOS.add(new FlightsInfo(2001, "Indigo", "Vizag", "Hyderabad", LocalDate.of(2020, 01, 30), LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00), 200, 52));
		FLIGHTSINFOS.add(new FlightsInfo(2021, "SpiceJet", "Banglore", "Hyderabad", LocalDate.of(2020, 01, 1),LocalDate.of(2020, 01, 05), LocalTime.of(6, 30, 00),LocalTime.of(8, 00, 00), 250, 212));
		FLIGHTSINFOS.add(new FlightsInfo(2022, "Indigo", "Chennai","Hyderabad", LocalDate.of(2020, 01, 30),LocalDate.of(2020, 02, 01), LocalTime.of(3, 30, 00),LocalTime.of(8, 30, 00), 150, 40));

		TICKETREQUESTINFOS.add(new TicketRequestInfo(new UsersInfo(107,"vital@gmail.com","vital",LocalDate.of(1990, 8, 12),"Mumbai","9295452346"), 
				                 new FlightsInfo(2001, "Indigo", "Vizag", "Hyderabad", LocalDate.of(2020, 01, 30), LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00), 200, 52), 5));
	    
	    TICKETREQUESTINFOS.add(new TicketRequestInfo(new UsersInfo(106,"lucky@gmail.com","lucky",LocalDate.of(2000, 4, 13),"Chennai","9491680796"), 
                new FlightsInfo(2001, "Indigo", "Vizag", "Hyderabad", LocalDate.of(2020, 01, 30), LocalDate.of(2020, 02, 01), LocalTime.of(12, 30, 00),LocalTime.of(3, 30, 00), 200, 52), 2));
	}
}
