package com.javafullstackfeb.airlinereservationsystemhibernate.services;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;

public interface AdminService {
	public UserInfo authenticateAdmin(String email, String password);

	public boolean registerAdmin(UserInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);

	public List<UserInfo> viewAllUsers();
	
	

}
